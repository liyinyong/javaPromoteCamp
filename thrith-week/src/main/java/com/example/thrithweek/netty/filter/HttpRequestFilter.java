package com.example.thrithweek.netty.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter {
    void filter(FullHttpRequest httpRequest, ChannelHandlerContext context);
}
