/**
 * 
 */
package com.kamal.promo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/**
 * Promo Engine Unit test cases
 *
 */
class PromoEngineTest {

	PromoEngine promoEngine;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) throws Exception {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		promoEngine = new PromoEngine();
	}

	@Test
	@DisplayName("FIXED_A_3_130")
	void FIXED_A_3_130() {
		Map<String, String> cartList = new HashMap<>();
		cartList.put("A", "5");
		double expected = 0;
		double actual = promoEngine.calculateTotalOrderValue(cartList);
		assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
	}

}
