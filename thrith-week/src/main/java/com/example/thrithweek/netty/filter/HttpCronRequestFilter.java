package com.example.thrithweek.netty.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpCronRequestFilter implements HttpRequestFilter{
    @Override
    public void filter(FullHttpRequest httpRequest, ChannelHandlerContext context) {
        httpRequest.headers().set("Access-Control-Allow-Origin", "*");
        httpRequest.headers().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
    }
}
