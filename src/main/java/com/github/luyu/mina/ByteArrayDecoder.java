package com.github.luyu.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;


public class ByteArrayDecoder extends CumulativeProtocolDecoder  {

    @Override
    public boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
            throws Exception {

        if (in.prefixedDataAvailable(4)) {
            int length = in.getInt();
            byte[] bytes = new byte[length];
            in.get(bytes);
            out.write(bytes);
            return true;
        } else {
            return false;
        }
    }
}
