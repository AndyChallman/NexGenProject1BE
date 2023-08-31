package com.skillstorm.controllers;

import java.util.List;

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

import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.WarehouseRepo;
import com.skillstorm.services.WarehouseServices;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin("*")
public class WarehouseController {

	@Autowired
	private WarehouseRepo repo;
	@Autowired
	private WarehouseServices warehouseService;
	
	public WarehouseController(WarehouseServices warehouseService) {
		this.warehouseService = warehouseService; 
	}
	@GetMapping
	public ResponseEntity<List<Warehouse>>getAllWarehouse(){
		List<Warehouse> warehouse = warehouseService.findAllWarehouse();
		return new ResponseEntity<>(warehouse, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Warehouse> getWarehouseById(@PathVariable("id") Integer id){
		Warehouse warehouse = warehouseService.findWarehousebyId(id);
		return new ResponseEntity<>(warehouse, HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity<Warehouse>addWarehouse(@RequestBody Warehouse warehouse){
		Warehouse newWarehouse = warehouseService.addWarehouse(warehouse);
		return new ResponseEntity<>(newWarehouse, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Warehouse>deleteWarehouse(@RequestBody Warehouse warehouse){
		warehouseService.deleteWarehouse(null);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Warehouse>updateWarehouse(@RequestBody Warehouse warehouse){
		Warehouse updateWarehouse = warehouseService.updateWarehouse(warehouse);
		return new ResponseEntity<>(updateWarehouse, HttpStatus.OK);
}
}
