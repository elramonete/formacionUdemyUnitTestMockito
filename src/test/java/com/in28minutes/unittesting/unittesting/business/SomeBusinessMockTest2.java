package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessMockTest2 {

//cogemos una copia del de SomeBusinessTest

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = Mockito.mock(SomeDataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});


        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        System.out.println("SomeBusinessMockTest2 - expectedResult " + expectedResult + " ,actualResult " + actualResult);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = Mockito.mock(SomeDataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });

        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();//new int[] {}
        int expectedResult = 0;
        System.out.println("SomeBusinessMockTest2 - expectedResult " + expectedResult + " ,actualResult " + actualResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = Mockito.mock(SomeDataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});


        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();//new int[] {5}
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}
