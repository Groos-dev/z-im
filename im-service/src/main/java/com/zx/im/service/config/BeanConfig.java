package com.zx.im.service.config;

import com.zx.im.common.config.AppConfig;
import com.zx.im.common.enums.ImUrlRouteWayEnum;
import com.zx.im.common.enums.RouteHashMethodEnum;
import com.zx.im.common.route.RouteHandle;
import com.zx.im.common.route.algorithm.consistenthash.AbstractConsistentHash;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author Mr.xin
 */
@Configuration
public class BeanConfig {
    @Autowired
    AppConfig appConfig;

    @Bean
    public ZkClient buildZKClient() {
        System.out.println(
                appConfig.getZkAddr()
        );
        return new ZkClient(appConfig.getZkAddr(),
                appConfig.getZkConnectTimeOut());
    }


    @Bean
    public RouteHandle routeHandle() throws Exception {

        Integer imRouteWay = appConfig.getImRouteWay();
        String routWay = "";

        ImUrlRouteWayEnum handler = ImUrlRouteWayEnum.getHandler(imRouteWay);
        routWay = handler.getClazz();

        RouteHandle routeHandle = (RouteHandle) Class.forName(routWay).newInstance();
        if(handler == ImUrlRouteWayEnum.HASH){

            Method setHash = Class.forName(routWay).getMethod("setHash", AbstractConsistentHash.class);
            Integer consistentHashWay = appConfig.getConsistentHashWay();
            String hashWay = "";

            RouteHashMethodEnum hashHandler = RouteHashMethodEnum.getHandler(consistentHashWay);
            hashWay = hashHandler.getClazz();
            AbstractConsistentHash consistentHash
                    = (AbstractConsistentHash) Class.forName(hashWay).newInstance();
            setHash.invoke(routeHandle,consistentHash);
        }

        return routeHandle;
    }

//    @Bean
//    public SnowflakeIdWorker buildSnowflakeSeq() throws Exception {
//        return new SnowflakeIdWorker(0);
//    }


}
