package com.example.mongo.mapper;

import com.example.mongo.model.GroceryItem;
import com.example.mongo.stubs.Category;
import com.example.mongo.stubs.GroceryItemProto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface IMapper {

    GroceryItemProto mapGroceryItem(GroceryItem groceryItem);

    GroceryItem mapGroceryItemRequestToGroceryItem(GroceryItemProto groceryItem);

    @EnumMapping(nameTransformationStrategy = MappingConstants.PREFIX_TRANSFORMATION, configuration = "CATEGORY_")
    Category mapCategoryToProto(GroceryItem.Category category);

    @EnumMapping(nameTransformationStrategy = MappingConstants.STRIP_PREFIX_TRANSFORMATION, configuration = "CATEGORY_")
    @ValueMapping(source = "UNRECOGNIZED", target = MappingConstants.NULL)
    GroceryItem.Category mapCategory(Category category);

}
