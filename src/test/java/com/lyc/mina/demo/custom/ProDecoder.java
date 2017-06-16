package com.lyc.mina.demo.custom;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by lyc on 2017/6/16.
 */
public class ProDecoder implements ProtocolDecoder{

    private final AttributeKey CONTEXT = new AttributeKey(this.getClass(),"context");
    private final Charset charset;

    private int maxPackLength = 100;

    public Context getContext(IoSession session){
        Context context = (Context) session.getAttribute(CONTEXT);
        if(null != context){
            context = new Context();
            session.setAttribute(CONTEXT,context);
        }
        return context;
    }


    public ProDecoder(Charset charset) {
        this.charset = charset;
    }

    public int getMaxPackLength() {
        return maxPackLength;
    }

    public void setMaxPackLength(int maxPackLength) throws IllegalAccessException {
        if(maxPackLength<0){
            throw new IllegalAccessException("maxPackException");
        }
        this.maxPackLength = maxPackLength;
    }

    public ProDecoder(){
        this(Charset.defaultCharset());
    }
    public Charset getCharset() {
        return charset;
    }

    public void decode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        final int packLength = 5;
        Context context = this.getContext(ioSession);
        context.append(ioBuffer);

        IoBuffer ioBuffer1 = context.getIoBuffer();
        ioBuffer1.flip();
        byte flag = ioBuffer1.get();

        while (ioBuffer1.remaining()>=packLength){
            ioBuffer1.mark();
            int length = ioBuffer1.getInt();
            if(length<0 || length>maxPackLength){
                ioBuffer1.reset();
                break;
            }else if(length>=packLength && (length-5)<=ioBuffer1.remaining()){
                int oldLimit = ioBuffer1.limit();
                ioBuffer1.limit(ioBuffer1.position()+length-packLength);
                String content = ioBuffer1.getString(context.getCharsetDecoder());
                ioBuffer1.limit(oldLimit);
                ProPack proPack = new ProPack(flag,content);
                protocolDecoderOutput.write(proPack);
            }else{//半包
                ioBuffer1.clear();
                break;
            }

            if(ioBuffer1.hasRemaining()){
                IoBuffer temp = IoBuffer.allocate(maxPackLength).setAutoExpand(true);
                temp.put(ioBuffer1);
                temp.flip();
                ioBuffer1.reset();
                ioBuffer1.put(temp);
            }else{
                ioBuffer1.reset();
            }
        }
    }

    public void finishDecode(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {

    }

    public void dispose(IoSession ioSession) throws Exception {
        Context context = (Context) ioSession.getAttribute(CONTEXT);
        if(null != context){
            ioSession.removeAttribute(CONTEXT);
        }
    }

    private class Context{
        private final CharsetDecoder charsetDecoder;

        private IoBuffer ioBuffer;

        private Context(){
            charsetDecoder = charset.newDecoder();
            ioBuffer = IoBuffer.allocate(80).setAutoExpand(true);
        }
        public void append(IoBuffer ioBuffer){
            this.getIoBuffer().put(ioBuffer);
        }

        public void rest(){
            charsetDecoder.reset();
        }

        public CharsetDecoder getCharsetDecoder() {
            return charsetDecoder;
        }

        public IoBuffer getIoBuffer() {
            return ioBuffer;
        }

        public void setIoBuffer(IoBuffer ioBuffer) {
            this.ioBuffer = ioBuffer;
        }
    }

}
