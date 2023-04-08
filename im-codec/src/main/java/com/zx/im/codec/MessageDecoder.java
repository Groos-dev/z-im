package com.zx.im.codec;

import com.zx.im.codec.proto.Message;
import com.zx.im.codec.utils.ByteBufToMessageUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Mr.xin
 */
public class MessageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        /**
         * command
         * byte.length
         * byte
         * 请求头 一共28个字节
         */
        if(in.readableBytes() < 28){
            return;
        }
        Message message = ByteBufToMessageUtils.transition(in);
        if(message == null) {
            return;
        }

        out.add(message);

    }
}
