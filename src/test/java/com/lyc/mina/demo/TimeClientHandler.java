package com.lyc.mina.demo;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by Administrator on 2017/6/12.
 */
public class TimeClientHandler extends IoHandlerAdapter {

    MinaTimeClient minaTimeClient;

    public TimeClientHandler(MinaTimeClient minaTimeClient) {
        this.minaTimeClient = minaTimeClient;
    }

    public void messageReceived(IoSession session, Object message) throws Exception {
        String content = message.toString();
        System.out.println("client receive a message is : " + content);

        minaTimeClient.setMsg(content);

    }

    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("messageSent -> ：" + message);
    }

}
