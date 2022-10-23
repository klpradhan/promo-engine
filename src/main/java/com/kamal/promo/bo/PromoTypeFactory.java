package com.kamal.promo.bo;

public class PromoTypeFactory {
	public PromoType createPromoType (String type) {
		PromoType promoType = null;
		
		if(type.indexOf("FIXED", 0) > -1) {
			promoType = new FixedPrice();
		} else if(type.indexOf("COMBO", 0) > -1) {
			promoType = new ComboPrice();
		} else if(type.indexOf("REGULAR", 0) > -1) {
			promoType = new RegularPrice();
		} else {
			promoType = new PriceExcluded();
		}
		
		return promoType;
	}
}
