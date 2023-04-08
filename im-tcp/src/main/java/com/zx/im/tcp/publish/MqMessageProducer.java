package com.zx.im.tcp.publish;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.zx.im.codec.proto.Message;
import com.zx.im.common.constant.Constants;
import com.zx.im.tcp.utils.MqFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Mr.xin
 */
@Slf4j
public class MqMessageProducer {

    public static void sendMessage(Message message, Integer command){
        Channel channel = null;
        String channelName = Constants.RabbitConstants.Im2MessageService;

        if(command.toString().startsWith("2")){
            channelName = Constants.RabbitConstants.Im2GroupService;
        }

        try {
            channel = MqFactory.getChannel(channelName);

            JSONObject o = (JSONObject) JSON.toJSON(message.getMessagePack());
            o.put("command",command);
            o.put("clientType",message.getMessageHeader().getClientType());
            o.put("imei",message.getMessageHeader().getImei());
            o.put("appId",message.getMessageHeader().getAppId());
            channel.basicPublish(channelName,"",
                    null, o.toJSONString().getBytes());
        }catch (Exception e){
            log.error("发送消息出现异常：{}",e.getMessage());
        }
    }

}
