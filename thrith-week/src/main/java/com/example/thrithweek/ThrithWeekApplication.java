package com.example.thrithweek;

import com.example.thrithweek.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThrithWeekApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThrithWeekApplication.class, args);
        NettyServer nettyServer = new NettyServer(8080);
        nettyServer.run();
    }

}
