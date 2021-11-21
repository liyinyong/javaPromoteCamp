package com.example.thrithweek.netty.route;

import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRouteConvert {
    String convertUrl(FullHttpRequest fullHttpRequest);
}
