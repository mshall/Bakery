package com.hexad.shall.bakery.model;

public class Pack {

	int quantity;
	Product product;
	double price;

	public Pack() {
	}

	public Pack(Product product, int quantity, double price) {
		this.quantity = quantity;
		this.product = product;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
