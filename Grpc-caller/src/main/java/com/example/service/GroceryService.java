package com.example.service;

import com.example.config.GrpcConfig;
import com.example.mongo.stubs.EmptyRequest;
import com.example.mongo.stubs.GetAllGroceryItemsResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GroceryService {

    private final GrpcConfig grpcConfig;

    @SneakyThrows
    public GetAllGroceryItemsResponse getAllGroceryItems() {
        System.out.println( grpcConfig.stub.getChannel());
        var request = EmptyRequest.newBuilder().setDummy("abcdjebhebhfhvefefevvfevjh").build();
        return  grpcConfig.stub.getAllGroceryItems(request);
    }

}
