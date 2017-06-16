package com.lyc.mina.demo.custom;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

/**
 * Created by lyc on 2017/6/16.
 */
public class ProFactory implements ProtocolCodecFactory {

    private final ProDecoder proDecoder;

    private final ProEncoder proEncoder;

    public ProFactory(Charset charset) {
        proDecoder = new ProDecoder(charset);
        proEncoder = new ProEncoder(charset);
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return proEncoder;
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return proDecoder;
    }
}
