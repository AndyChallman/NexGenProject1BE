package com.skillstorm.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity 
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int id;
	@Column(name = "item_name")
	private String name;
	@Column(name = "item_weight")
	private int weight;
	@Column(name = "image_link")
	private String image;
	@Column(name = "item_quantity")
	private int quantity;
	@Column(name = "item_max_quantity")
	private int maxQuantity;
	@Column(name = "warehouse_id")
	private int warehouseId;

	public Inventory() {}
	public Inventory(int id, String name, int weight, String image, int quantity, int maxQuantity, int warehouseId ) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.image = image;
		this.quantity = quantity;
		this.maxQuantity= maxQuantity;
		this.warehouseId = warehouseId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(String image) {
		this.image = image;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, image, maxQuantity, name, quantity, warehouseId, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return id == other.id && Objects.equals(image, other.image) && maxQuantity == other.maxQuantity
				&& Objects.equals(name, other.name) && quantity == other.quantity && warehouseId == other.warehouseId
				&& weight == other.weight;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", weight=" + weight + ", image=" + image + ", quantity="
				+ quantity + ", maxQuantity=" + maxQuantity + ", warehouseId=" + warehouseId + "]";
	}
	
}
	