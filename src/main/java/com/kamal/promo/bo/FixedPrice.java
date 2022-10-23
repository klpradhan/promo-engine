/**
 * 
 */
package com.kamal.promo.bo;

import java.util.List;
import java.util.Map;

/**
 * @author kamal
 *
 */
public class FixedPrice extends PromoType {

	@Override
	public double applyPromo(List<String> cart, String type) {
		double totalOrderValue = 0;
//		Map<String, String> activePromos = promoEngineUtils.getActivePromotions();
		Map<String, Double> unitPrice = promoEngineUtils.getUnitPrice();
		String sku = cart.get(0);
		Integer qty = Integer.valueOf(cart.get(1));
		totalOrderValue += calculatePromo(sku, qty, type, unitPrice);
		return totalOrderValue;
	}

	private double calculatePromo(String sku, Integer orderedQty, String promo, Map<String, Double> unitPrice) {
		double total = 0;
		String[] promoVal = promo.split("_");
		// Sample: FIXED_A_3_130
		if ("FIXED".equals(promoVal[0])) {
			if (sku.equals(promoVal[1])) {
				int promoQty = Integer.valueOf(promoVal[2]);
				int promoPrice = Integer.valueOf(promoVal[3]);
				int promoEligibleQty = orderedQty / promoQty;
				total += promoPrice * promoEligibleQty;

				int promoNotEigibleQty = orderedQty % promoQty;
				Double price = unitPrice.get(sku);
				total += price * promoNotEigibleQty;

				return total;
			}
		}
		return total;
	}

}
