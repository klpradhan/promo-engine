/**
 * 
 */
package com.kamal.promo.bo;

import java.util.List;
import java.util.Map;

/**
 * Combo price calculation
 *
 */
public class ComboPrice extends PromoType {

	@Override
	public double applyPromo(List<String> cartItem, String type) {
		Map<String, Double> unitPrice = promoEngineUtils.getUnitPrice();
		String sku = cartItem.get(0);
		Integer qty = Integer.valueOf(cartItem.get(1));
		return calculatePromo(sku, qty, type, unitPrice);
	}

	private double calculatePromo(String sku, Integer qty, String type, Map<String, Double> unitPrice) {
		String[] promoVal = type.split("_");
		Double comboPrice = Double.valueOf(promoVal[promoVal.length-1]);
		
		return comboPrice;
	}

}
