package com.kamal.promo.bo;

import java.util.List;
import java.util.Map;

public class PercentagePrice extends PromoType {

	@Override
	public double applyPromo(List<String> cartItem, String type) {
		Map<String, Double> unitPrice = promoEngineUtils.getUnitPrice();
		String sku = cartItem.get(0);
		Integer qty = Integer.valueOf(cartItem.get(1));
		return calculatePromo(sku, qty, type, unitPrice);
	}

	private double calculatePromo(String sku, Integer qty, String type, Map<String, Double> unitPrice) {
		String[] promoVal = type.split("_");
		if(!unitPrice.containsKey(sku)) return 0;
		
		Double totalValue = unitPrice.get(sku) * qty;
		Double percentage = Double.valueOf(promoVal[promoVal.length-1]);
		Double reduction = totalValue * (percentage / 100);
		
		return totalValue - reduction;
	}

}
