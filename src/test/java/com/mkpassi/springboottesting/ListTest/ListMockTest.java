package com.mkpassi.springboottesting.ListTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

	List listMock = mock(List.class);

	@Test
	void test() {
		when(listMock.size()).thenReturn(10);
		assert (listMock.size() == 10);
	}

	@Test
	void testMultipleReturns() {
		when(listMock.size()).thenReturn(10).thenReturn(20);
		assert (listMock.size() == 10);
		assert (listMock.size() == 20);
	}

	@Test
	void testReturnWithParameters() {
		when(listMock.get(0)).thenReturn("SomeString");
		assert (listMock.get(0).equals("SomeString"));
		assert (listMock.get(1) == null);
	}

	/** Argument Matchers */

	@Test
	void testReturnWithGenericParameters() {
		when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");
		assert (listMock.get(0).equals("SomeString"));
		assert (listMock.get(1).equals("SomeString"));
	}

	/** Verify */

	@Test
	void testVerify() {
		String value1 = (String) listMock.get(0);
		String value2 = (String) listMock.get(1);
		Mockito.verify(listMock).get(0);
		Mockito.verify(listMock).get(1);
	}

	@Test
	void testVerifyTimes() {
		String value1 = (String) listMock.get(0);
		String value2 = (String) listMock.get(1);
		Mockito.verify(listMock, Mockito.times(2)).get(Mockito.anyInt());
		Mockito.verify(listMock, Mockito.atLeast(1)).get(Mockito.anyInt());
		Mockito.verify(listMock, Mockito.atMost(2)).get(Mockito.anyInt());
		Mockito.verify(listMock, Mockito.never()).get(2);
	}

	@Test
	void testVerifyWithArgumentMatchers() {
		String value1 = (String) listMock.get(0);
		String value2 = (String) listMock.get(1);
		Mockito.verify(listMock).get(Mockito.anyInt());
		Mockito.verify(listMock).get(Mockito.anyInt());
	}

	/** Argument Capture */

	@Test
	void testArgumentCapture() {
		listMock.add("SomeString");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(listMock).add(captor.capture());
		assert (captor.getValue().equals("SomeString"));
	}

	@Test
	void testMultipleArgumentCapture() {
		listMock.add("SomeString1");
		listMock.add("SomeString2");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(listMock, Mockito.times(2)).add(captor.capture());
		assert (captor.getAllValues().size() == 2);
		assert (captor.getAllValues().get(0).equals("SomeString1"));
		assert (captor.getAllValues().get(1).equals("SomeString2"));
	}

	@Test
	void spying(){
		List listSpy = Mockito.spy(List.class);
		doReturn(10).when(listSpy).size();
		assert (listSpy.size() == 10);
	}
}
