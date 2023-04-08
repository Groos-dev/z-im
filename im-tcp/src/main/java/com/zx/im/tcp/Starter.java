package com.zx.im.tcp;

import com.zx.im.tcp.config.BootstrapConfig;
import com.zx.im.tcp.reciver.MessageReciver;
import com.zx.im.tcp.redis.RedisManager;
import com.zx.im.tcp.register.RegistryZK;
import com.zx.im.tcp.register.ZKit;
import com.zx.im.tcp.server.ImServer;
import com.zx.im.tcp.server.ImWebSocketServer;
import com.zx.im.tcp.utils.MqFactory;
import org.I0Itec.zkclient.ZkClient;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Starter {


    //    HTTP GET POST PUT DELETE 1.0 1.1 2.0
    //client IOS 安卓 pc(windows mac) web //支持json 也支持 protobuf
    //appId
    //28 + imei + body
    //请求头（指令 版本 clientType 消息解析类型 imei长度 appId bodylen）+ imei号 + 请求体
    //len+body
    public static void main(String[] args) {
        //program args 中传入config.yml 绝对路径
        if(args.length > 0){
            start(args[0]);
        }
    }


    public static void start(String path){
        // path 启动参数传入
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            BootstrapConfig bootstrapConfig = yaml.loadAs(fileInputStream, BootstrapConfig.class);
            new ImServer(bootstrapConfig.getLim()).start();
            new ImWebSocketServer(bootstrapConfig.getLim()).start();

            RedisManager.init(bootstrapConfig);
            MqFactory.init(bootstrapConfig.getLim().getRabbitmq());
            MessageReciver.init(bootstrapConfig.getLim().getBrokerId()+"");

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(5000);
        }



    }


    public static void registerZK(BootstrapConfig config) throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        ZkClient zkClient = new ZkClient(config.getLim().getZkConfig().getZkAddr(),
                config.getLim().getZkConfig().getZkConnectTimeOut());
        ZKit zKit = new ZKit(zkClient);
        RegistryZK registryZK = new RegistryZK(zKit, hostAddress, config.getLim());
        Thread thread = new Thread(registryZK);
        thread.start();
    }



}
