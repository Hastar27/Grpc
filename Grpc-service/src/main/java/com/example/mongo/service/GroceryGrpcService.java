package com.example.mongo.service;

import com.example.mongo.mapper.IMapper;
import com.example.mongo.model.GroceryItem;
import com.example.mongo.repository.ItemRepository;
import com.example.mongo.stubs.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.lognet.springboot.grpc.GRpcService;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Controller class for GroceryGrpcService
 */
@GRpcService
@RequiredArgsConstructor
public class GroceryGrpcService extends GroceryGrpcServiceGrpc.GroceryGrpcServiceImplBase {

    private final ItemRepository groceryItemRepo;
    private final IMapper mapper;

    @Override
    public void addGroceryItems(GroceryItemRequest request, StreamObserver<GetAllGroceryItemsResponse> responseObserver) {
        System.out.println("Data creation started...");

        var groceryItems = request.getGroceryItemList()
                .stream()
                .map(mapper::mapGroceryItemRequestToGroceryItem)
                .collect(Collectors.toSet());

        List<GroceryItem> savedResponse = groceryItemRepo.saveAll(groceryItems);

        var response = savedResponse.stream()
                .map(mapper::mapGroceryItem)
                .collect(Collectors.toList());


        System.out.println("Data creation complete...");
        responseObserver.onNext(GetAllGroceryItemsResponse.newBuilder()
                .addAllGroceryItemResponseDto(response).build());
    }

    @Override
    public void getAllGroceryItems(EmptyRequest request, StreamObserver<GetAllGroceryItemsResponse> responseObserver) {
        var builder = GetAllGroceryItemsResponse.newBuilder();

        Optional.of(groceryItemRepo.findAll())
                .ifPresent(items -> {
                    items.removeIf(Objects::isNull);
                    List<GroceryItemProto> responseDtos = items.stream()
                            .map(mapper::mapGroceryItem)
                            .collect(Collectors.toList());
                    builder.addAllGroceryItemResponseDto(responseDtos);
                });


        builder.addAllGroceryItemResponseDto(groceryItemRepo.findAll()
                .stream()
                .map(mapper::mapGroceryItem)
                .collect(Collectors.toList()));

        System.out.println(builder.build());

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getGroceryItemByName(GetGroceryItemByNameRequest request, StreamObserver<GroceryItemProto> responseObserver) {
        super.getGroceryItemByName(request, responseObserver);
    }

    @Override
    public void getGroceryItemsByCategory(GetGroceryItemByCategoryRequest request, StreamObserver<GroceryItemProto> responseObserver) {
        super.getGroceryItemsByCategory(request, responseObserver);
    }
}
