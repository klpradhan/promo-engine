/**
 * 
 */
package com.kamal.promo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kamal.promo.bo.PromoType;
import com.kamal.promo.bo.PromoTypeFactory;
import com.kamal.promo.utils.PromoEngineUtils;

/**
 * Promo Engine Calculate promo of given skus in the cart and return the total
 * order value
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
		Map<String, List<String>> promoToCartItem = new HashMap<>();
		promoToCartItem = promoEligibilityCheck(cartList);

		for (String type : promoToCartItem.keySet()) {
			List<String> cartItem = promoToCartItem.get(type);

			PromoType promoType = promoTypeFactory.createPromoType(type);
			orderValue += promoType.applyPromo(cartItem, type);
		}

		return orderValue;
	}

	private Map<String, List<String>> promoEligibilityCheck(Map<String, String> cartList) {
		Map<String, List<String>> activePromos = promoUtils.getActivePromotions();
		Map<String, List<String>> promoToCartItem = new HashMap<>();
		Set<String> skuVisited = new HashSet<String>();

		for (String sku : cartList.keySet()) {
			if (skuVisited.contains(sku))
				continue;
			if (activePromos.containsKey(sku)) {
				List<String> promos = activePromos.get(sku);
				// select a single promo - business logic is pending to choose best promo can be
				// applied to a SKU
				String promoSelected = promos.get(0);
				String[] promoVal = promoSelected.split("_");
				if ("FIXED".equals(promoVal[0])) {
					// sample promo: FIXED_A_3_130
					promoToCartItem.put(promoSelected, new ArrayList<String>(Arrays.asList(sku, cartList.get(sku))));
				}
			} else {
				promoToCartItem.put("REGULAR", new ArrayList<String>(Arrays.asList(sku, cartList.get(sku))));
			}

			skuVisited.add(sku);
		}

		return promoToCartItem;
	}

}
