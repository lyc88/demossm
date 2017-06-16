package com.lyc.mina.demo.custom;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;

/**
 * Created by lyc on 2017/6/16.
 */
public class ProEncoder extends ProtocolEncoderAdapter {
    private final Charset charset;

    public ProEncoder(Charset charset) {
        this.charset = charset;
    }

    public void encode(IoSession ioSession, Object o, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        ProPack v = (ProPack) o;
        IoBuffer ioBuffer = IoBuffer.allocate(v.getLength());
        ioBuffer.setAutoExpand(true);
        ioBuffer.putInt(v.getLength());
        ioBuffer.put(v.getFlag());
        if(v.getContent()!=null){
            ioBuffer.put(v.getContent().getBytes());
        }
        ioBuffer.flip();
        protocolEncoderOutput.write(ioBuffer);
    }
}
