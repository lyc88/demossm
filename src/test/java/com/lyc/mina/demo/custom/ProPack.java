package com.lyc.mina.demo.custom;

/**
 * Created by lyc on 2017/6/16.
 */
public class ProPack {
    private int length;
    private byte flag;
    private String content;

    public ProPack(byte flag,String content){
        this.content = content;
        this.flag = flag;
        int len = content==null?0:content.getBytes().length;
        this.length = len+5;
    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ProPack{" +
                "length=" + length +
                ", flag=" + flag +
                ", content='" + content + '\'' +
                '}';
    }
}
