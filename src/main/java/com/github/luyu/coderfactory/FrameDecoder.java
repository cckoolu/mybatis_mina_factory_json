package com.github.luyu.coderfactory;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

public class FrameDecoder extends CumulativeProtocolDecoder {

    @Override
    protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        int totalLength = ioBuffer.getInt();
        int messageLength = totalLength - 4;
        if (ioBuffer.remaining() >= messageLength) {
            String messageString = ioBuffer.getString(messageLength, Charset.forName("UTF-8").newDecoder());
            protocolDecoderOutput.write(messageString);
            return true;
        }
        return false;
    }
}