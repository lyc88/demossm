package com.lyc.mina.demo.custom;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by lyc on 2017/6/16.
 */
public class Client {
    private static final int port = 7080;

    private static final String HOST = "127.0.0.1";

    static long c = 0;
    static int f = 100;

    static long s = 0;
    public static void main(String[] args) {
        s = System.currentTimeMillis();
        IoConnector connector = new NioSocketConnector();

        connector.getFilterChain().addLast("coderc",new ProtocolCodecFilter(new ProFactory(Charset.forName("UTF-8"))));

        connector.getSessionConfig().setReadBufferSize(1024);
        connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);

        connector.setHandler(new MyHandler1());
        ConnectFuture connectFuture = connector.connect(new InetSocketAddress(HOST,port));

        connectFuture.addListener(new IoFutureListener<ConnectFuture>() {
            @Override
            public void operationComplete(ConnectFuture ioFuture) {
                if(ioFuture.isConnected()){
                    IoSession session = ioFuture.getSession();
                    sendata(session);
                }
            }
        });
    
    }

    private static void sendata(IoSession session) {

        for (int i=0;i<10;i++){
            String c = "hell0"+i;
            ProPack proPack = new ProPack((byte) i,c);
            session.write(proPack);
            System.out.println("客户端+"+proPack);
        }
    }
}
class MyHandler1 extends IoHandlerAdapter{
    public MyHandler1() {
        super();
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {

        if(status == IdleStatus.READER_IDLE){
            session.close(true);
        }
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        ProPack proPack = (ProPack) message;
        System.out.println("客户端接受"+proPack);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }
}