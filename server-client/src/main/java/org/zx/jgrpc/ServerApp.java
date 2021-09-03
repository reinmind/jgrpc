package org.zx.jgrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author xiang.zhang
 * @date 2021/8/31
 */
@Slf4j
public class ServerApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(10080)
                .addService(new GreetingServiceImpl())
                .build();
        server.start();
        log.info("server started");
        server.awaitTermination();
    }
}
