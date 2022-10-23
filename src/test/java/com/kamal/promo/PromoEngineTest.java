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
		double expected = 230;
		double actual = promoEngine.calculateTotalOrderValue(cartList);
		assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
	}
	
	@Test
	@DisplayName("FIXED_B_2_45")
	void Fixed_B_test() {
		Map<String, String> cartList = new HashMap<>();
		cartList.put("B", "5");
		double expected = 120;
		double actual = promoEngine.calculateTotalOrderValue(cartList);
		assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
	}
	
	@Test
	@DisplayName("COMBO_C_D_1_30")
	void Combo_C_D_Test() {
		Map<String, String> cartList = new HashMap<>();
		cartList.put("C", "1");
		cartList.put("D", "1");
		double expected = 30;
		double actual = promoEngine.calculateTotalOrderValue(cartList);
		assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
	}
	
	@Test
	@DisplayName("SCENARIO_A")
	void Scenario_A_Test() {
		Map<String, String> cartList = new HashMap<>();
		cartList.put("A", "1");
		cartList.put("B", "1");
		cartList.put("C", "1");
		double expected = 100;
		double actual = promoEngine.calculateTotalOrderValue(cartList);
		assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
	}

	@Test
	@DisplayName("SCENARIO_B")
	void Scenario_B_Test() {
		Map<String, String> cartList = new HashMap<>();
		cartList.put("A", "5");
		cartList.put("B", "5");
		cartList.put("C", "1");
		double expected = 370;
		double actual = promoEngine.calculateTotalOrderValue(cartList);
		assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
	}
	
	@Test
	@DisplayName("SCENARIO_C")
	void Scenario_C_Test() {
		Map<String, String> cartList = new HashMap<>();
		cartList.put("A", "3");
		cartList.put("B", "5");
		cartList.put("C", "1");
		cartList.put("D", "1");
		double expected = 280;
		double actual = promoEngine.calculateTotalOrderValue(cartList);
		assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
	}
	
}
