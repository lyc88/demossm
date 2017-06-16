package com.lyc.mina.demo.custom;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by lyc on 2017/6/16.
 */
public class Server {

    private static final int port = 7080;
    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor();

        acceptor.getFilterChain().addLast("coderc",new ProtocolCodecFilter(new ProFactory(Charset.forName("UTF-8"))));

        acceptor.getSessionConfig().setReadBufferSize(1024);

        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
        //发送
        acceptor.setHandler(new MyHandler());

        acceptor.bind(new InetSocketAddress(port));
        System.out.println("开始。。。。。。。。。。。");
    }
}
class MyHandler extends IoHandlerAdapter{

    public MyHandler() {
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
        System.out.println("过期----");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("异常处理。。。。。");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        ProPack proPack = (ProPack) message;
        System.out.println("接受"+proPack);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }
}