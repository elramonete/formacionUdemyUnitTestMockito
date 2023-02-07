package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
//https://chuwiki.chuidiang.org/index.php?title=Ejemplo_sencillo_con_Mockito
//	https://www.adictosaltrabajo.com/2009/01/29/mockito/
	//https://danielme.com/2017/07/24/tutorial-test-doubles-mockito/
	//https://devs4j.com/2018/04/27/pruebas-unitarias-parte-3-introduccion-a-spying/#:~:text=%C2%BFQu%C3%A9%20es%20un%20Spy%20y,le%20conoce%20como%20partial%20mocking.
	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	@Disabled
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameters() {
		//cualquiero get(0) get(21) ... get(entero) nos devuelve ese valor "in28Minutes"
		when(mock.get(anyInt())).thenReturn("in28Minutes");

		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(1));
	}

	@Test
	public void verificationBasics() {

		//https://www.adictosaltrabajo.com/2009/01/29/mockito/

		// SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		String value3 = mock.get(2);

		// Verify
		verify(mock).get(0);
		//llama 3 veces
		verify(mock, times(3)).get(anyInt());
		//al menos 1 vez
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		//maximo 3 veces
		verify(mock, atMost(3)).get(anyInt());
		//al tener 3 no podemos poner 2
		verify(mock, never()).get(3);
	}

	@Test
	public void argumentCapturing() {
		
		//SUT añadimos a la lista el valor string "SomeString"
		mock.add("SomeString");

		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing() {
		
		//SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock, times(2)).add(captor.capture());
		//assertEquals("SomeString",captor.getValue();
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
		
	}

	@Test
	public void mocking() {
		//la diferencia entre mock y spy es la talla "size", mientras que el mock siempre deuvelve 0, el spy devuelve el array de valores.
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3 comparamos con la linea 120
		
		//when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5 aqui devolvemos 5 pq o es 5 o entonces no pasa el test.
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5 si tenemos el when linea 135  sino devuelve 4

		arrayListSpy.add("Test5");
		System.out.println(arrayListSpy.size());//5 si tenemos el when linea 135  sino devuelve 5

		arrayListSpy.add("Test6");
		System.out.println(arrayListSpy.size());//5 si tenemos el when linea 135  sino devuelve 6
		
		verify(arrayListSpy).add("Test0");//comprueba o verifica que existe ese valor
	}

	
}
