package org.zx.jgrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiang.zhang
 * @date 2021/8/31
 */
@Slf4j
public class ClientApp {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:10081")
                .usePlaintext()
                .build();
        log.info("channel status: {}",channel.getState(true));
        // create a block stub
        GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub = GreetingServiceGrpc.newBlockingStub(channel);
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName("Rin")
                .build();
        // call remote service & get result
        GreetingServiceOuterClass.HelloResponse response = blockingStub.greeting(request);
        log.info("get response from server: {}",response);
        channel.shutdownNow();
    }
}
