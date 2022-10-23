/**
 * 
 */
package com.kamal.promo.bo;

import java.util.List;

import com.kamal.promo.utils.PromoEngineUtils;

/**
 * @author kamal
 *
 */
public abstract class PromoType {
	protected PromoEngineUtils promoEngineUtils;

	public PromoType() {
		this.promoEngineUtils = new PromoEngineUtils();
	}

	abstract public double applyPromo(List<String> cartItem, String type);
}
