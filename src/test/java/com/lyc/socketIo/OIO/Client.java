package com.lyc.socketIo.OIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/6/18.
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),6488);
            os = socket.getOutputStream();
            String s1;
            s1 = new String("我是客户端".getBytes(), Charset.forName("UTF-8"));
            os.write(s1.getBytes());
            //shutdownOutput():执行此方法，显式的告诉服务端发送完毕！
            socket.shutdownOutput();
            is = socket.getInputStream();
            byte[] b = new byte[20];
            int len;
            while((len = is.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.print(str);
            }

          String s = "";
            while((len = is.read(b)) != -1){
                 s += new String(b,0,len);
            }
            System.out.print("服务端"+s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

    }
}
