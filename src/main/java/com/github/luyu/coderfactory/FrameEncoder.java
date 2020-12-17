package com.github.luyu.coderfactory;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FrameEncoder implements ProtocolEncoder {

    @Override
    public void encode(IoSession ioSession, Object o, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        if (o instanceof String) {
            String messageString = (String) o;
            //封装为 Frame 协议
            byte[] messageBytes = messageString.getBytes(StandardCharsets.UTF_8);
            int totalSize = messageBytes.length + 4;
            IoBuffer buffer = IoBuffer.allocate(totalSize);
            buffer.putInt(totalSize);
            buffer.put(messageBytes);
            buffer.flip();
            protocolEncoderOutput.write(buffer);
        }
    }

    @Override
    public void dispose(IoSession ioSession) throws Exception {

    }
}