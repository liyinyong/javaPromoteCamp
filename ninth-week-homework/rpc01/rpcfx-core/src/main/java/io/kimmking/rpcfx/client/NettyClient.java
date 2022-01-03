package io.kimmking.rpcfx.client;

import io.kimmking.rpcfx.api.RpcfxRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class NettyClient {
    public static void connectServer(String host, int port, String url, String param) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler((new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HttpClientCodec()).addLast(new OutputResultHandler());
                        }
                    }));
            Channel channel = bootstrap.connect(host, port).sync().channel();
            DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, new URI(url).toASCIIString());
            request.content().readBytes(param.getBytes());
            request.headers().set("Content-Type", "application/json");
            request.headers().set("Content-Length", request.content().readableBytes());
            channel.writeAndFlush(request).sync();
            channel.closeFuture().sync();
        } catch (Exception e) {

        }finally {
            workGroup.shutdownGracefully();
        }
    }

    private static class OutputResultHandler extends SimpleChannelInboundHandler<FullHttpResponse> {
        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception {
            ByteBuf buf = fullHttpResponse.content();
            buf.toString(CharsetUtil.UTF_8);
        }
    }
}
