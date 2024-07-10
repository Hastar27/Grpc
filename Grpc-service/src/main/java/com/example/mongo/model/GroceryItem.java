package com.example.mongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("grocery_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryItem {

    @Id
    private String id;
    private String name;
    private int quantity;
    private Category category;

    public enum Category {
        UNDEFINED,
        SNACKS,
        MILLETS,
        SPICES
        ;
    }
}
