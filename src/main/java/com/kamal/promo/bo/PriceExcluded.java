/**
 * 
 */
package com.kamal.promo.bo;

import java.util.List;

/**
 * IGNORE case to exclude one of the combo sku
 *
 */
public class PriceExcluded extends PromoType {

	@Override
	public double applyPromo(List<String> cartItem, String type) {
		return 0;
	}

}
