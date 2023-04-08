package com.zx.im.codec;

import com.alibaba.fastjson.JSONObject;
import com.zx.im.codec.proto.MessagePack;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Mr.xin
 */
public class MessageEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        if(o instanceof MessagePack){
            MessagePack messagePack = (MessagePack) o;
            String s = JSONObject.toJSONString(messagePack.getData());
            byte[] bytes = s.getBytes();
            byteBuf.writeInt(messagePack.getCommand());
            byteBuf.writeInt(bytes.length);
            byteBuf.writeBytes(bytes);
        }
    }
}
