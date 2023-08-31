package com.skillstorm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Warehouse;
import com.skillstorm.models.Inventory;

@Repository
public interface InventoryRepo extends CrudRepository<Inventory, Integer>{


	void deleteInventoryById(Integer id);

	Optional<Inventory> findInventoryById(Integer id);

	@Query(value = "SELECT * FROM inventory WHERE warehouse_id = ?1", nativeQuery = true)
	List<Inventory> findAllInventoryByWarehouseId(Integer warehouseId);
	
}
