package com.hexad.shall.bakery.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderProcessor {

	public static void main(String[] args) {
		readOrders();
	}

	public static void initiateProcessing() {

	}

	public static Map<String, Integer> readOrders() {
		// This should return all lines
		// qty & code of each line
		Map<String, Integer> ordersMap = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line == "\n" || line == " " || line == null) {
				break;
			}
			String[] lineWords = line.split(" ");
			int quantity = Integer.parseInt(lineWords[0]);
			String productCode = lineWords[1];
			ordersMap.put(productCode, quantity);

		}
		scanner.close();

		return ordersMap;
	}
	
    public static void processOrderFile( Map<String, Integer> orders) {
    	
        
        int grandTotalItems = 0;
        double grandTotalPrice = 0.0;
        double deliveryPricePerItem = 1.25;

        orders.forEach((key,value) -> {
        	
        });

       
    }



}
