package org.zx.jgrpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiang.zhang
 * @date 2021/8/31
 */
@Slf4j
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request, StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        log.info("request: {}",request);
        GreetingServiceOuterClass.HelloResponse response = null;
        try {
            response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                    .setGreeting(String.format("Konichiwa %s,your hobbies %s", request.getName(),new ObjectMapper().writeValueAsString(request.getHobbiesList())))
                    .build();
        } catch (JsonProcessingException e) {
            log.error("convert hobbies to json error : {}",request.getHobbiesList());
        }
        // send a response back
        responseObserver.onNext(response);
        // call when completed
        responseObserver.onCompleted();
    }
}
