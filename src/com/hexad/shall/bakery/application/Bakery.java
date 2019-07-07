package com.hexad.shall.bakery.application;

import java.util.Map;

import com.hexad.shall.bakery.processor.OrderProcessor;

public class Bakery {

	public static void main(String[] args) {
		Map<String, Integer> ordersMap = OrderProcessor.readOrders();
		OrderProcessor.processOrders(ordersMap);
	}

}
