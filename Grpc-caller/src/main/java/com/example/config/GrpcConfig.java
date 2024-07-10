package com.example.config;

import com.example.mongo.stubs.GroceryGrpcServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class GrpcConfig {

    private static final ClassLoader classLoader = GrpcConfig.class.getClassLoader();
    public GroceryGrpcServiceGrpc.GroceryGrpcServiceBlockingStub stub;
    private static final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090").usePlaintext().build();

    @PostConstruct
    private void init() throws ClassNotFoundException {
        Class.forName("com.example.mongo.stubs.GroceryGrpcServiceGrpc");
        stub = GroceryGrpcServiceGrpc.newBlockingStub(channel);
    }

    @PreDestroy
    private void cleanUp() {
        channel.shutdown();
    }

}
