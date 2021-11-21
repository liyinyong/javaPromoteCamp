package com.example.thrithweek.netty.config;

import com.example.thrithweek.netty.handler.HttpRequestDefaultHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpNettyServerInitConfig extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        channelPipeline.addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(1024*1024))
                .addLast(new HttpRequestDefaultHandler());
    }
}
