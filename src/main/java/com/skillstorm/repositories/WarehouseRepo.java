package com.skillstorm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.skillstorm.models.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Integer>{


	void deleteWarehouseByWarehouseId(@Param("warehouse_id")Integer warehouseId);
	
	Optional<Warehouse> findWarehouseByWarehouseId(@Param("warehouse_id")Integer warehouseId);
	
}
