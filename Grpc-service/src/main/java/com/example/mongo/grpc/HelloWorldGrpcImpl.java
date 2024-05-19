package com.example.mongo.grpc;

import com.example.mongo.stubs.HelloWorldRequest;
import com.example.mongo.stubs.HelloWorldResponse;
import com.example.mongo.stubs.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * test
 */
@GrpcService
public class HelloWorldGrpcImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void sayHello(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
//        super.sayHello(request, responseObserver);
        System.out.println("request: " + request);
        responseObserver.onNext(HelloWorldResponse.newBuilder()
                .setGreeting("Greeting")
                .build());
        responseObserver.onCompleted();
    }
}
