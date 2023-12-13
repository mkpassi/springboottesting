package com.mkpassi.springboottesting.buisness;

import com.mkpassi.springboottesting.service.interfaces.SomeDataService;

import java.util.Arrays;

public class SimpleSum {

	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

  public int CalculateSum(int[] data) {
    return Arrays.stream(data).reduce(Integer::sum).orElse(0);
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
