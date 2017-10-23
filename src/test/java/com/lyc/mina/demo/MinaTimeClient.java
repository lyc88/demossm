package com.lyc.mina.demo;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
public class MinaTimeClient {

    private String msg;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String a(String a,MinaTimeClient minaTimeClient){
        // 创建客户端连接器.
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

        // 设置连接超时检查时间
        connector.setConnectTimeoutCheckInterval(30);
        connector.setHandler(new TimeClientHandler(minaTimeClient));

        // 建立连接
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1", 6488));
        // 等待连接创建完成
        cf.awaitUninterruptibly();

        cf.getSession().write("Hi Server!");
        cf.getSession().write("quit");

        // 等待连接断开
        cf.getSession().getCloseFuture().awaitUninterruptibly();
        // 释放连接
        connector.dispose();

        return minaTimeClient.getMsg();
    }

    public static void main(String[] args){

        MinaTimeClient minaTimeClient = new MinaTimeClient();
        System.out.println(minaTimeClient.a("",minaTimeClient));
    }
}
