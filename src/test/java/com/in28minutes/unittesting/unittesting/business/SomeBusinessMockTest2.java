package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import  static org.mockito.Mockito.when;
import  static org.mockito.Mockito.mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SomeBusinessMockTest2 {

//cogemos una copia del de SomeBusinessTest
    //clase git youtube
    //https://www.youtube.com/watch?v=PW_A-lOpVV0

    // Pasamos SomeBusinessMockTest2 a SomeBusinessMockTest 13.Step08 en el min2
    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = Mockito.mock(SomeDataService.class);

    List<String> mock = mock(List.class);

    @BeforeEach
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }

    @Test
    public void test_size_basic(){

        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void test_different_Values(){

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());

    }

    @Test
    public void calculateSumUsingDataService_basic() {

        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        System.out.println("SomeBusinessMockTest2 - calculateSumUsingDataService_basic - expectedResult " + expectedResult + " ,actualResult " + actualResult);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void calculateSumUsingDataService_empty() {

        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });

        int actualResult = business.calculateSumUsingDataService();//new int[] {}
        int expectedResult = 0;
        System.out.println("SomeBusinessMockTest2 - calculateSumUsingDataService_empty - expectedResult " + expectedResult + " ,actualResult " + actualResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {

        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});

        int actualResult = business.calculateSumUsingDataService();//new int[] {5}
        int expectedResult = 5;
        System.out.println("SomeBusinessMockTest2 - -calculateSum_oneValue - expectedResult " + expectedResult + " ,actualResult " + actualResult);
        assertEquals(expectedResult, actualResult);
    }

}
