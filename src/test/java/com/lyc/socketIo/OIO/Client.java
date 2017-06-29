package com.lyc.socketIo.OIO;

import java.io.DataOutputStream;
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
            socket = new Socket(InetAddress.getByName("112.74.54.67"),8765);
            os = socket.getOutputStream();
            String s1;
            s1 = new String("我是客户端我是客$_".getBytes(), Charset.forName("UTF-8"));
            os.write(s1.getBytes("UTF-8"));
            DataOutputStream dataOutputStream = new DataOutputStream(os);
            //dataOutputStream.
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();

            InputStream in = socket.getInputStream();
            byte[] b1 = new byte[1024];
            int len1;
            while((len1 = in.read(b1)) != -1){
                String str = new String(b1,0,len1);
                System.out.print(str);
            }

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
