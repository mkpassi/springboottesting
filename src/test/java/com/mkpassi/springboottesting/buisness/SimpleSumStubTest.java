package com.mkpassi.springboottesting.buisness;

import com.mkpassi.springboottesting.service.interfaces.SomeDataService;
import org.junit.jupiter.api.Test;

public class SimpleSumStubTest {

	@Test
	void testCalculateSumUsingDataService() {
		SimpleSum simpleSum = new SimpleSum();
		simpleSum.setSomeDataService(new SomeDataServiceStub());
		int sum = simpleSum.CalculateSumUsingDataService();
		int expected = 6;
		assert (sum == expected);
	}

	@Test
	void testCalculateSumUsingDataService_empty() {
		SimpleSum simpleSum = new SimpleSum();
		simpleSum.setSomeDataService(new SomeDataServiceStubEmpty());
		int sum = simpleSum.CalculateSumUsingDataService();
		int expected = 0;
		assert (sum == expected);
	}

	@Test
	void testCalculateSumUsingDataService_oneValue() {
		SimpleSum simpleSum = new SimpleSum();
		simpleSum.setSomeDataService(new SomeDataServiceStubOneValue());
		int sum = simpleSum.CalculateSumUsingDataService();
		int expected = 5;
		assert (sum == expected);
	}

}


class SomeDataServiceStubOneValue implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
}


class SomeDataServiceStubEmpty implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}

}


class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}

}
