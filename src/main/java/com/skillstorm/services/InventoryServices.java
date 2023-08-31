package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.exceptions.InventoryNotFoundException;
import com.skillstorm.models.Inventory;
import com.skillstorm.repositories.InventoryRepo;
import com.skillstorm.repositories.WarehouseRepo;

@Service
public class InventoryServices 	{
	@Autowired
	private InventoryRepo inventoryRepo;
	
	@Autowired
	private WarehouseRepo warehouseRepo;


    InventoryServices(InventoryRepo inventoryRepo, WarehouseRepo warehouseRepo) {
        this.inventoryRepo = inventoryRepo;
        this.warehouseRepo = warehouseRepo;
    }
	
	public Inventory addInventory(Inventory inventory) {
		inventory.setId(0);
		return inventoryRepo.save(inventory);
		
	}
	public Iterable<Inventory> findAllInventory(){
		return inventoryRepo.findAll();
	}
	public Inventory updateInventory(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}
	public Inventory findInventoryById(Integer id) {
		return inventoryRepo.findInventoryById(id)
				.orElseThrow(() -> new InventoryNotFoundException("Inventory item by id " + id + " was not found"));
		
	}
	public List<Inventory> findAllInventoryByWarehouseId(Integer warehouseId) {
		return inventoryRepo.findAllInventoryByWarehouseId(warehouseId);
	}
	public void deleteInventory(Integer id) {
		inventoryRepo.deleteInventoryById(id);
	}
}