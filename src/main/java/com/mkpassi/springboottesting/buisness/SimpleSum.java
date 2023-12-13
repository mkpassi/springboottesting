package com.mkpassi.springboottesting.buisness;

import com.mkpassi.springboottesting.service.interfaces.SomeDataService;

public class SimpleSum {

	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int CalculateSum(int[] data) {
		int sum = 0;
		for(int value : data) {
			sum += value;
		}
		return sum;
	}

	public int CalculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.retrieveAllData();
		for(int value : data) {
			sum += value;
		}
		return sum;
	}

}
