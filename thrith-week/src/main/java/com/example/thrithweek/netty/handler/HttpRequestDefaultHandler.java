package com.example.thrithweek.netty.handler;

import com.example.thrithweek.netty.filter.HttpCronRequestFilter;
import com.example.thrithweek.netty.filter.HttpRequestFilter;
import com.example.thrithweek.netty.route.HttpDefaultRouteConvert;
import com.example.thrithweek.netty.route.HttpRouteConvert;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@Slf4j
public class HttpRequestDefaultHandler extends ChannelInboundHandlerAdapter {

    HttpRequestFilter httpRequestFilter = new HttpCronRequestFilter();

    HttpRouteConvert httpRouteConvert = new HttpDefaultRouteConvert();

    ExecutorService executorService;

    public HttpRequestDefaultHandler() {
        executorService = new ThreadPoolExecutor(8, 16, 2000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            executorService.execute(() -> {
                FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
                httpRequestFilter.filter(fullHttpRequest, ctx);
                String url = httpRouteConvert.convertUrl(fullHttpRequest);
                fullHttpRequest.setUri(url);
                FullHttpResponse fullHttpResponse = handleRequest(fullHttpRequest);
                ctx.write(fullHttpResponse);
                ctx.flush();
            });

        } catch (Exception e) {
            log.error("解析httpRequest错误{}", e);
        }
    }

    private FullHttpResponse handleRequest(FullHttpRequest fullHttpRequest) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(fullHttpRequest.uri());
            byte[] body = httpClient.execute(httpGet, httpResponse -> {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status < 200 || status >= 300) {
                    // ... handle unsuccessful request
                }
                HttpEntity entity = httpResponse.getEntity();
                return entity != null ? EntityUtils.toByteArray(entity) : null;
            });
            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
            response.headers().set("Content-Type", "application/json");
            response.headers().set("Content-Length", body.length);
            return response;
        } catch (IOException e) {
            // ... handle IO exception
        }
        return new DefaultFullHttpResponse(HTTP_1_1, OK);
    }
}
