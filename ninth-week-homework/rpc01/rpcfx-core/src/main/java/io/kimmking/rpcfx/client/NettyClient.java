package io.kimmking.rpcfx.client;

import io.kimmking.rpcfx.api.RpcfxRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Slf4j
public class NettyClient {
    public static String connectServer(String host, int port, String url, String param) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            final FullHttpResponse[] httpResponse = new FullHttpResponse[1];
            bootstrap.group(workGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler((new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HttpClientCodec()).addLast(new OutputResultHandler());
                        }
                    }));
            Channel channel = bootstrap.connect(host, port).sync().channel();
            ByteBuf byteBuf = Unpooled.wrappedBuffer(param.getBytes());
            DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, new URI(url).toASCIIString(), byteBuf);
            request.headers().set("Content-Type", "application/json");
            request.headers().set("Content-Length", request.content().readableBytes());
            channel.writeAndFlush(request).sync();
            channel.closeFuture().sync();
            return null;
        } catch (Exception e) {
            log.error("sss", e);
            return null;
        } finally {
            workGroup.shutdownGracefully();
        }
    }

    private static class OutputResultHandler extends SimpleChannelInboundHandler<FullHttpResponse> {
        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception {
            log.info("信息{}", fullHttpResponse.content().toString(StandardCharsets.UTF_8));
        }
    }
}
