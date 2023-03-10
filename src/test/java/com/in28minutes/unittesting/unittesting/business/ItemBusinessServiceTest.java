package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService business;

	@Mock
	private ItemRepository repository;

	@Test
	public void retrieveAllItems_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10),
				new Item(3,"Item3",20,20),
				new Item(4,"Item4",5,5)));
		List<Item> items = business.retrieveAllItems();
		
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
		assertEquals(25, items.get(2).getValue());
	}


	@Test
	public void retreiveHardcodedItem_basic() {
		//ItemBusinessService business = new ItemBusinessService();
		//int actualResult = business.retreiveHardcodedItem();
		Item expected = new Item(1, "Basket", 10, 33);
		Item actual = business.retreiveHardcodedItem();
		System.out.println(actual.getName());
		assertEquals(expected.getName(), actual.getName());

	}
}
