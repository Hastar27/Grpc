package com.example.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.*"})
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableMongoRepositories
public class MongoApplication {


	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("-----CREATE GROCERY ITEMS-----\n");
//
//		createGroceryItems();
//
//		System.out.println("\n-----SHOW ALL GROCERY ITEMS-----\n");
//
//		showAllGroceryItems();
//
//		System.out.println("\n-----GET ITEM BY NAME-----\n");
//
//		getGroceryItemByName("Whole Wheat Biscuit");
//
//		System.out.println("\n-----GET ITEMS BY CATEGORY-----\n");
//
//		getItemsByCategory(GroceryItem.Category.MILLETS);
//
//		System.out.println("\n-----UPDATE CATEGORY NAME OF SNACKS CATEGORY-----\n");
//
//		updateCategoryName(GroceryItem.Category.SNACKS, GroceryItem.Category.SPICES);
//
//		System.out.println("\n-----DELETE A GROCERY ITEM-----\n");
//
//		deleteGroceryItem("Kodo Millet");
//
//		System.out.println("\n-----FINAL COUNT OF GROCERY ITEMS-----\n");
//
//		findCountOfGroceryItems();
//
//		System.out.println("\n-----THANK YOU-----");
//	}

	//CREATE
//	void createGroceryItems() {
//		System.out.println("Data creation started...");
//		groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, GroceryItem.Category.SNACKS));
//		groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, GroceryItem.Category.MILLETS));
//		groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, GroceryItem.Category.SPICES));
//		groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, GroceryItem.Category.MILLETS));
//		groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, GroceryItem.Category.SNACKS));
//		System.out.println("Data creation complete...");
//	}
//
//	// READ
//	// 1. Show all the data
//	public void showAllGroceryItems() {
//
//		groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
//	}
//
//	// 2. Get item by name
//	public void getGroceryItemByName(String name) {
//		System.out.println("Getting item by name: " + name);
//		GroceryItem item = groceryItemRepo.findItemByName(name);
//		System.out.println(getItemDetails(item));
//	}
//
//	// 3. Get name and quantity of a all items of a particular category
//	public void getItemsByCategory(GroceryItem.Category category) {
//		System.out.println("Getting items for the category " + category);
//		List<GroceryItem> list = groceryItemRepo.findAll(category);
//
//		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
//	}
//
//	// 4. Get count of documents in the collection
//	public void findCountOfGroceryItems() {
//		long count = groceryItemRepo.count();
//		System.out.println("Number of documents in the collection: " + count);
//	}
//
//	public String getItemDetails(GroceryItem item) {
//
//		System.out.println(
//				"Item Name: " + item.getName() +
//						", \nQuantity: " + item.getQuantity() +
//						", \nItem Category: " + item.getCategory()
//		);
//
//		return "";
//	}
//
//	public void updateCategoryName(GroceryItem.Category categoryToUpdate, GroceryItem.Category newCategoryValue) {
//
//		// Find all the items with the category snacks
//		List<GroceryItem> groceryItems = groceryItemRepo.findAll(categoryToUpdate);
//
//		groceryItems.forEach(item -> {
//			// Update the category in each document
//			item.setCategory(newCategoryValue);
//		});
//
//		// Save all the items in database
//		List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(groceryItems);
//
//        System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
//	}
//
//	// DELETE
//	public void deleteGroceryItem(String id) {
//		groceryItemRepo.deleteById(id);
//		System.out.println("Item with id " + id + " deleted...");
//	}
}
