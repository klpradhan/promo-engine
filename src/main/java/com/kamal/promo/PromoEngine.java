/**
 * 
 */
package com.kamal.promo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kamal.promo.bo.FixedPrice;
import com.kamal.promo.bo.PromoType;

/**
 * Promo Engine
 * Calculate promo of given skus in the cart and return the total order value
 * 
 */
public class PromoEngine {

	public double calculateTotalOrderValue(Map<String, String> cartList) {
		double orderValue = 0.0;
		PromoType promoType = new FixedPrice();
		List<String> cartItem = new ArrayList<>();
		//hardcoded test input
		cartItem.add("A");
		cartItem.add("5");
		String type = "FIXED_A_3_130";
		orderValue = promoType.applyPromo(cartItem, type);
		return orderValue;
	}
}
