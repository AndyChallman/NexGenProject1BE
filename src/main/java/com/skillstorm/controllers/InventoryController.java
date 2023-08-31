package com.skillstorm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Inventory;
import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.InventoryRepo;
import com.skillstorm.services.InventoryServices;


	@RestController
	@RequestMapping("/inventory")
	@CrossOrigin("*")
	public class InventoryController  {
		
		@Autowired
		private InventoryRepo inventoryRepo;
		
		@Autowired
		private InventoryServices inventoryServices;
	
	public InventoryController(InventoryServices inventoryService) {
		this.inventoryServices = inventoryServices; 
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Inventory>>getAllInventory(){
		Iterable<Inventory> inventory = inventoryServices.findAllInventory();
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	// here, we specify that we're taking that PathVariable into the method
	public Inventory getInventoryById(@PathVariable int id) {
		Optional<Inventory> result = inventoryRepo.findById(id);  // repo.findById() returns an Optional, so we have to .get() the Album out of it
		if (result.isPresent())
			return result.get();
		else
			return null;
	}
	
	
	@PostMapping
	public ResponseEntity<Inventory>addInventory(@RequestBody Inventory inventory){
				if (inventoryRepo.existsById(inventory.getId())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(inventory);
				} else {
				return ResponseEntity.status(HttpStatus.CREATED).body(inventoryRepo.save(inventory));
			}
		}
	
	@PutMapping("/update")
	public ResponseEntity<Inventory>updateInventory(@RequestBody Inventory inventory){
		System.out.println(inventory);
		Inventory updateInventory = inventoryServices.updateInventory(inventory);
		return new ResponseEntity<>(updateInventory, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Inventory>deleteInventory(@RequestBody Inventory inventory){

		{
			inventoryRepo.delete(inventory);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(inventory);
		} 

	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInventoryByPathId(@PathVariable int id) {
		if (inventoryRepo.existsById(id)) {
			inventoryRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Inventory Item with id of " + id + " was successfully deleted.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Inventory Item with id of " + id + " does not exist!");
		}
	}
	@GetMapping("/find/inventory/{inventoryId}")
	public ResponseEntity<List<Inventory>> getAllInventoryByWarehouseId(@PathVariable("warehouseId") Integer warehouseId) {
	    List<Inventory> inventory = inventoryServices.findAllInventoryByWarehouseId(warehouseId);
	     return new ResponseEntity<>(inventory, HttpStatus.OK);
	}
	
}