package com.example.thrithweek.netty;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {
    public static void main(String[] args) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:8080");
            String responseBody = httpClient.execute(httpGet, httpResponse -> {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status < 200 || status >= 300) {
                    // ... handle unsuccessful request
                }
                HttpEntity entity = httpResponse.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            });
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("结果：" + responseBody);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
