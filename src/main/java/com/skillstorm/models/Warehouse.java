package com.skillstorm.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="warehouses")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "warehouseId")
public class Warehouse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	private int warehouseId;
	
	@Column(name = "warehouse_address")
	private String address;
	
	@Column(name = "warehouse_capacity")
	private int capacity;
	
	
	public Warehouse() {
		super();
	}

	public Warehouse(int id, String address, int capacity) {
		super();
		this.warehouseId = id;
		this.address = address;
		this.capacity = capacity;
	}
	
	public int getWarehouseId() {
		return warehouseId;
	}
	
	public void setWarehouseId(int id) {
		this.warehouseId = id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, capacity, warehouseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		return Objects.equals(address, other.address) && capacity == other.capacity && warehouseId == other.warehouseId;
	}

	@Override
	public String toString() {
		return "Warehouse [id=" + warehouseId + ", address=" + address + ", capacity=" + capacity + "]";
	}
	
	
	
	
}

