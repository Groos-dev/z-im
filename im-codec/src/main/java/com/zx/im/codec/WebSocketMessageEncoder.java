package com.zx.im.codec;

import com.alibaba.fastjson.JSONObject;
import com.zx.im.codec.proto.MessagePack;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Mr.xin
 */
public class WebSocketMessageEncoder extends MessageToMessageEncoder<Object> {

    private static Logger log = LoggerFactory.getLogger(WebSocketMessageEncoder.class);
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object msg, List<Object> out) throws Exception {
        if(msg instanceof MessagePack){
            String s = JSONObject.toJSONString(msg);
            ByteBuf byteBuf = Unpooled.directBuffer(8 + s.length());
            byte[] bytes = s.getBytes();
            byteBuf.writeInt(((MessagePack<?>) msg).getCommand());
            byteBuf.writeInt(bytes.length);
            byteBuf.writeBytes(bytes);
            out.add(new BinaryWebSocketFrame(byteBuf));
        }

    }
}
