package com.hexad.shall.bakery.model;

public class OrderPack {

	int quantity;
	int packSize;
	double unitPrice;

	public OrderPack() {
	}

	public OrderPack(int quantity, int packSize, double unitPrice) {
		super();
		this.quantity = quantity;
		this.packSize = packSize;
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPackSize() {
		return packSize;
	}

	public void setPackSize(int packSize) {
		this.packSize = packSize;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
