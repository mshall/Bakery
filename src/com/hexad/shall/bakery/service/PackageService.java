package com.hexad.shall.bakery.service;

import java.util.Collections;
import java.util.List;

import com.hexad.shall.bakery.model.OrderLine;
import com.hexad.shall.bakery.model.OrderPack;

public class PackageService {

	/**
	 * Calculate packages required for order
	 *
	 * @param packages - permissible packages for given product
	 * @param quantity - number of individual items for given product
	 * @returns {OrderLine}
	 */
	public OrderLine calculatePackages(List<OrderPack> packages, int quantity) {

		// Collections.sort(packages, Collections.reverseOrder());

		double totalPrice = 0;
		boolean lineItemComplete = false;
		OrderLine orderLineObject = new OrderLine();

		if (packages.size() != 0 && quantity != 0) {
			int index = 0;
			for (int i = 0; i < packages.size(); i++) {
				index++;
				OrderPack currentPackage = packages.get(i);
				int val = (int) Math.floor(quantity / currentPackage.getPackSize());
				int remainder = quantity % currentPackage.getPackSize();

				if (lineItemComplete)
					break;

				if (remainder == 0) {
					double linePrice = val * currentPackage.getUnitPrice();
					totalPrice += linePrice;

					orderLineObject.addItemPack(val, currentPackage.getPackSize(), currentPackage.getUnitPrice());

					lineItemComplete = true;
				} else {
					// Check package remainder size.
					// Is there an exact match for the remainder?
					List<OrderPack> furtherPackages = packages.subList(index, packages.size());

					// if we take the current package, could the rest of the order be fulfilled
					// using the next package?
					for (int j = 0; j < furtherPackages.size(); j++) {
						OrderPack fPackage = furtherPackages.get(j);

						if (!lineItemComplete) {
							int childVal = remainder / fPackage.getPackSize();

							if (childVal % 1 == 0) {
								// Add the 'parent' package as the child package sums to the required item
								// quantity
								orderLineObject.addItemPack(val, currentPackage.getPackSize(),
										currentPackage.getUnitPrice());
								orderLineObject.addItemPack(childVal, fPackage.getPackSize(), fPackage.getUnitPrice());
								lineItemComplete = true;
							}

						}
					}
				}

			}
		}

		return orderLineObject;
	}

}

/**
 * Sort packages in descending order by pack size
 * 
 * @param a
 * @param b
 */
/*
 * public _sortPacks(OrderPack firstPack, OrderPack secondPack) { if (a.packSize
 * > b.packSize) { return b; } else { return (b.packSize < a.packSize) ? -1 : 1;
 * }
 */
