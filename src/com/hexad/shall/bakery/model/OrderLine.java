package com.hexad.shall.bakery.model;

import java.util.ArrayList;
import java.util.List;

public class OrderLine {

	double totalPrice;
	List<OrderPack> packages;
	int totalQuantity;

	public OrderLine(double totalPrice, List<OrderPack> packages, int totalQuantity) {
		this.totalPrice = totalPrice;
		this.packages = packages;
		this.totalQuantity = totalQuantity;
	}

	public OrderLine() {
		this.packages = new ArrayList<>();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalAmount) {
		this.totalPrice = totalAmount;
	}

	public List<OrderPack> getPackages() {
		return packages;
	}

	public void setPackages(List<OrderPack> packages) {
		this.packages = packages;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public void addItemPack(int quantity, int packSize, double unitPrice) {
		this.totalQuantity += (quantity * packSize);
		this.totalPrice += (unitPrice * quantity);
		this.packages.add(new OrderPack(quantity, packSize, unitPrice));
	}

}
