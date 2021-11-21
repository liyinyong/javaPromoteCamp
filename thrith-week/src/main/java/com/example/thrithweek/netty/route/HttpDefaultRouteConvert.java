package com.example.thrithweek.netty.route;

import io.netty.handler.codec.http.FullHttpRequest;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HttpDefaultRouteConvert implements HttpRouteConvert {
    private String route = "http://localhost:8081,http://localhost:8082";

    /**
     * 可以读取eureka配置信息进行路由筛选
     * @param fullHttpRequest
     * @return
     */
    @Override
    public String convertUrl(FullHttpRequest fullHttpRequest) {
        List<String> routes = Arrays.asList(route.split(",")).stream().collect(Collectors.toList());
        return this.loadBalance(routes);
    }

    private String loadBalance(List<String> routes) {
        Random random = new Random();
        return routes.get(random.nextInt(2));
    }
}
