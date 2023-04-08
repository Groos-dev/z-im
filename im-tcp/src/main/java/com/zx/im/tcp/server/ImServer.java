package com.zx.im.tcp.server;

import com.zx.im.codec.MessageDecoder;
import com.zx.im.codec.MessageEncoder;
import com.zx.im.tcp.config.BootstrapConfig;
import com.zx.im.tcp.handler.HeartBeatHandler;
import com.zx.im.tcp.handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mr.xin
 */
public class ImServer {
    private final static Logger logger = LoggerFactory.getLogger(ImServer.class);
    private BootstrapConfig.TcpConfig config;
    private NioEventLoopGroup bossGroup;
    private NioEventLoopGroup workerGroup;

    private ServerBootstrap server;
    public ImServer(BootstrapConfig.TcpConfig config){
        this.config = config;
        this.bossGroup = new NioEventLoopGroup(config.getBossThreadSize());
        this.workerGroup = new NioEventLoopGroup(config.getWorkThreadSize());
        this.server = new ServerBootstrap();
        server.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,10240)
                // 服务端可连接队列的大小
                .option(ChannelOption.SO_REUSEADDR,true)
                // 可以重复使用本地端口
                .childOption(ChannelOption.TCP_NODELAY,true)
                //关闭批量发送消息，开启会提高消息的及时性
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                // 保活开关2h没有数据通信服务端会发送心跳包
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new MessageDecoder())
                                .addLast(new MessageEncoder())
                                .addLast(new HeartBeatHandler(config.getHeartBeatTime()))
                                .addLast(new NettyServerHandler(config.getBrokerId(),config.getLogicUrl()));
                    }
                });

    }

    public void start(){
        this.server.bind(this.config.getTcpPort());
    }
}
