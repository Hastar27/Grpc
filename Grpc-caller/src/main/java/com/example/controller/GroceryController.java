package com.example.controller;

import com.example.mongo.stubs.EmptyRequest;
import com.example.mongo.stubs.GetAllGroceryItemsResponse;
import com.example.mongo.stubs.GroceryGrpcServiceGrpc;
import com.example.service.GroceryService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/grocery")
@RequiredArgsConstructor
public class GroceryController {

    private final GroceryService groceryService;


    @GetMapping(value = "/get-all")
    public GetAllGroceryItemsResponse getAllGroceryItemsResponse() {
        return groceryService.getAllGroceryItems();
    }
}
