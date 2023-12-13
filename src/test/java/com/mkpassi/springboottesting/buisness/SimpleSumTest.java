package com.mkpassi.springboottesting.buisness;

import com.mkpassi.springboottesting.service.interfaces.SomeDataService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SimpleSumTest {

	SomeDataService someDataService;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		//someDataService = mock(SomeDataService.class);
	}


	@Test
	void testCalculateSum() {
		SimpleSum simpleSum = new SimpleSum();
		int sum = simpleSum.CalculateSum(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected, sum);
	}

	@Test
	void testCalculateSumUsingDataService() {

	}



}
