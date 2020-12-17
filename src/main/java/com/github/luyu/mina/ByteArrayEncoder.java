package com.github.luyu.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import java.nio.charset.StandardCharsets;


/**
 *  编码器将数据直接发出去(不做处理)
 */
public class ByteArrayEncoder extends ProtocolEncoderAdapter {

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        String str = (String) message;

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        IoBuffer buffer = IoBuffer.allocate(12, false);
//        IoBuffer buffer = IoBuffer.allocate(bytes.length, false);
        buffer.setAutoExpand(true);
        buffer.put(bytes);
//        buffer.putInt(bytes.length);
        buffer.flip();
        out.write(buffer);
    }

}
