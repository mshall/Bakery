package com.hexad.shall.bakery.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.hexad.shall.bakery.model.OrderLine;
import com.hexad.shall.bakery.model.OrderPack;
import com.hexad.shall.bakery.service.PackageService;

public class OrderProcessor {

	static PackageService packageService = new PackageService();

	/**
	 * This method is responsible for Reading orders from the user
	 * 
	 * @returns Map<String, Integer> orders
	 */
	public static Map<String, Integer> readOrders() {

		System.out.println("********************************");
		System.out.println("Please enter desired orders, a product each line!");
		Map<String, Integer> ordersMap = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line == "\n" || line == " " || line.isEmpty() || line == null) {
				break;
			} else {
				String[] lineWords = line.split(" ");
				int quantity = Integer.parseInt(lineWords[0]);
				String productCode = lineWords[1];
				ordersMap.put(productCode, quantity);
			}
		}
		scanner.close();
		System.out.println("Thank you, you order is being processed!");
		System.out.println("********************************");
		return ordersMap;
	}

	/**
	 * This method is responsible for Processing the order after getting the order
	 * from the user
	 *
	 * @param orders - Map of orders received from the user
	 */
	public static void processOrders(Map<String, Integer> orders) {
		int grandTotalItems = 0;
		double grandTotalPrice = 0.0;
		Set<Entry<String, Integer>> ordersEntrySet = orders.entrySet();
		for (Entry<String, Integer> entry : ordersEntrySet) {
			String productCode = entry.getKey();
			int productQuantity = entry.getValue();
			int orderQuantity = productQuantity;
			String orderProduct = productCode;

			List<OrderPack> productPacks = getPackagesForProduct(productCode);
			OrderLine orderLine = packageService.calculatePackages(productPacks, orderQuantity);

			grandTotalItems += orderLine.getTotalQuantity();
			grandTotalPrice += orderLine.getTotalPrice();

			System.out.println(orderQuantity + "" + orderProduct + "$" + orderLine.getTotalPrice());

			List<OrderPack> packs = orderLine.getPackages();
			packs.forEach(pack -> {
				System.out
						.println("       " + pack.getQuantity() + "x" + pack.getPackSize() + "$" + pack.getUnitPrice());
			});

		}
		if (grandTotalItems == 0)

		{
			System.out.println(
					"Sorry, the order could not be fulfilled due to a mis-match between order quantity and pack size");
		} else {

			System.out.println("Total number of individual items in order:" + grandTotalItems);
			System.out.println("Total price of items: $" + grandTotalPrice);

		}
	}

	/**
	 * This method is responsible for Fetching available packages for a specific
	 * product
	 *
	 * @param productCode - This is the unique identifier for a product
	 * @returns List<OrderPack> - available product packages
	 */
	public static List<OrderPack> getPackagesForProduct(String productCode) {
		List<OrderPack> packsList = new ArrayList<>();
		switch (productCode) {
		case "VS5":
			OrderPack firstVSOrderPack = new OrderPack(1, 3, 6.99);
			OrderPack secondVSOrderPack = new OrderPack(1, 5, 8.99);
			packsList.add(firstVSOrderPack);
			packsList.add(secondVSOrderPack);
			break;
		case "MB11":
			OrderPack firstMBOrderPack = new OrderPack(1, 8, 9.95);
			OrderPack secondMBOrderPack = new OrderPack(1, 5, 16.95);
			OrderPack thirdMBOrderPack = new OrderPack(1, 2, 24.95);
			packsList.add(firstMBOrderPack);
			packsList.add(secondMBOrderPack);
			packsList.add(thirdMBOrderPack);
			break;
		case "CF":
			OrderPack firstCFOrderPack = new OrderPack(1, 9, 5.95);
			OrderPack secondCFOrderPack = new OrderPack(1, 5, 9.95);
			OrderPack thirdCFOrderPack = new OrderPack(1, 3, 16.99);
			packsList.add(firstCFOrderPack);
			packsList.add(secondCFOrderPack);
			packsList.add(thirdCFOrderPack);
			break;

		}
		return packsList;
	}
}
