package com.mkpassi.springboottesting.service;

import static com.mkpassi.protobuf.SpringTestingProtobuf.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mkpassi.springboottesting.data.entity.ItemEntity;
import com.mkpassi.springboottesting.data.repository.ItemRepository;
import com.mkpassi.springboottesting.mapper.ItemMapper;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
  @InjectMocks
  private ItemBusinessService service;
  @Mock
  private ItemRepository repository;
  @Mock
  private ItemMapper mapper;

  @Test
  void testRetrieveAllItems() throws Exception {
    List<ItemEntity> itemEntityList =
        Arrays.asList(new ItemEntity(2, "Item2", 10, 10), new ItemEntity(3, "Item3", 20, 20));
    List<Item> itemList =
        Arrays.asList(
            Item.newBuilder().setId(2).setName("Item2").setPrice(10).setQuantity(10).setValue(100).build(),
            Item.newBuilder().setId(3).setName("Item3").setPrice(20).setQuantity(20).setValue(400).build());
    when(repository.findAll()).thenReturn(itemEntityList);
    when(mapper.ItemEntityListToItemList(anyList())).thenReturn(itemList);
    List<Item> items = service.retrieveAllItems();
    assertEquals(2, items.size());
    assertEquals(10, items.get(0).getPrice());
    assertEquals(20, items.get(1).getPrice());
    assertEquals(100, items.get(0).getValue());
    assertEquals(400, items.get(1).getValue());
  }
}
