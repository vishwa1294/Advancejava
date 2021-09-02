package com.xworkz.camera.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "camera_table")

public class CameraEntity implements Serializable {

	@Column(name = "c_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "c_name")
	private String name;
	@Column(name = "c_brand")
	private String brand;
	@Column(name = "c_type")
	private String type;
	@Column(name = "c_price")
	private double price;
	@Column(name = "c_weight")
	private int weight;
	@Column(name = "c_battery_type")
	private String batteryType;
	@Column(name = "c_warranty")
	private int warranty;
	@Column(name = "c_flash")
	private boolean flash;
	@Column(name = "c_pixel")
	private int pixel;

	public CameraEntity() {
	}

	public CameraEntity(String name, String brand, String type, double price, int weight, String batteryType, int warranty,
			boolean flash, int pixel) {
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.weight = weight;
		this.batteryType = batteryType;
		this.warranty = warranty;
		this.flash = flash;
		this.pixel = pixel;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof CameraEntity) {
			CameraEntity casted = (CameraEntity) obj;
			if (this.name.equals(casted.name) && this.type.equals(casted.type) && this.brand.equals(casted.brand)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "CameraEntity [id=" + id + ", name=" + name + ", brand=" + brand + ", type=" + type + ", price=" + price
				+ ", weight=" + weight + ", batteryType=" + batteryType + ", warranty=" + warranty + ", flash=" + flash
				+ ", pixel=" + pixel + "]";
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public boolean isFlash() {
		return flash;
	}

	public void setFlash(boolean flash) {
		this.flash = flash;
	}

	public int getPixel() {
		return pixel;
	}

	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
}