/**
 * 
 */
package com.kamal.promo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kamal.promo.bo.PromoType;
import com.kamal.promo.bo.PromoTypeFactory;
import com.kamal.promo.utils.PromoEngineUtils;

/**
 * Promo Engine
 * Calculate promo of given skus in the cart and return the total order value
 * 
 */
public class PromoEngine {
	
	private PromoTypeFactory promoTypeFactory;
	private PromoEngineUtils promoUtils;

	public PromoEngine() {
		this.promoTypeFactory = new PromoTypeFactory();
		this.promoUtils = new PromoEngineUtils();
	}
	public double calculateTotalOrderValue(Map<String, String> cartList) {
		double orderValue = 0.0;
		List<String> cartItem = new ArrayList<>();
		//hardcoded test input
		cartItem.add("A");
		cartItem.add("5");
		String type = "FIXED_A_3_130";
		PromoType promoType = promoTypeFactory.createPromoType(type);
		orderValue = promoType.applyPromo(cartItem, type);
		return orderValue;
	}
}
