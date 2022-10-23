package com.kamal.promo.bo;

public class PromoTypeFactory {
	public PromoType createPromoType(String type) {
		PromoType promoType = null;

		if (type.indexOf("FIXED", 0) > -1) {
			promoType = new FixedPrice();
		}

		return promoType;
	}
}
