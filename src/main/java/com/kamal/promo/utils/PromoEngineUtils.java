/**
 * 
 */
package com.kamal.promo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Promo Engine Utils
 * It can be enhanced to read from either a file or database, and fill up the required data structures
 *
 */
public class PromoEngineUtils {
	//Unit prices for SKUs
	private Map<String, Double> unitPrice;
	
	//Active promotions
	private Map<String, List<String>> activePromotions;
	
	public PromoEngineUtils() {
		//For testing purpose : Test data setup
		unitPrice = new HashMap<String, Double>();
		unitPrice.put("A",(double) 50);
		unitPrice.put("B",(double) 30);
		unitPrice.put("C",(double) 20);
		unitPrice.put("D",(double) 15);
		
		activePromotions = new HashMap<String, List<String>>();
		activePromotions.put("A", new ArrayList<String>(Arrays.asList("FIXED_A_3_130")));
		activePromotions.put("B", new ArrayList<String>(Arrays.asList("FIXED_B_2_45")));
		activePromotions.put("C", new ArrayList<String>(Arrays.asList("COMBO_C_D_1_30")));
		activePromotions.put("D", new ArrayList<String>(Arrays.asList("COMBO_C_D_1_30")));
		
	}

	public Map<String, Double> getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Map<String, Double> unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Map<String, List<String>> getActivePromotions() {
		return activePromotions;
	}

	public void setActivePromotions(Map<String, List<String>> activePromotions) {
		this.activePromotions = activePromotions;
	}
	
	
}
