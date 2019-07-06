package com.hexad.shall.bakery.model;

public class Order {

	double totalAmount;
	Pack[] packs;
	
	public Order(double totalAmount,Pack[] packs) {
		this.totalAmount = totalAmount;
		this.packs = packs;
	}

	public Order() {
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
