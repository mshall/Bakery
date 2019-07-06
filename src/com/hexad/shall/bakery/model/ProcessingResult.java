package com.hexad.shall.bakery.model;

public class ProcessingResult {

	int flag;
	Pack pack;
	Product[] products;

	public ProcessingResult() {
	}

	public ProcessingResult(int flag, Pack pack, Product[] products) {
		this.flag = flag;
		this.pack = pack;
		this.products = products;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

}
