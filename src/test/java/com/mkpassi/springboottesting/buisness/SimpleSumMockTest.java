package com.mkpassi.springboottesting.buisness;

import com.mkpassi.springboottesting.service.interfaces.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SimpleSumMockTest {

	@InjectMocks
	SimpleSum simpleSum;
	@Mock
	SomeDataService someDataServiceMock;

	@Test
	void testCalculateSumUsingDataService() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		int sum = simpleSum.CalculateSumUsingDataService();
		int expected = 6;
		assert (sum == expected);
	}

	@Test
	void testCalculateSumUsingDataService_empty() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int sum = simpleSum.CalculateSumUsingDataService();
		int expected = 0;
		assert (sum == expected);
	}

	@Test
	void testCalculateSumUsingDataService_oneValue() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		int sum = simpleSum.CalculateSumUsingDataService();
		int expected = 5;
		assert (sum == expected);
	}

}
