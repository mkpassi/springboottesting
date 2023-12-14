package com.mkpassi.springboottesting.service;

import com.mkpassi.protobuf.SpringTestingProtobuf.Item;
import com.mkpassi.springboottesting.data.entity.ItemEntity;
import com.mkpassi.springboottesting.data.repository.ItemRepository;
import com.mkpassi.springboottesting.mapper.ItemMapper;
import com.mkpassi.springboottesting.service.interfaces.IItemBusinessService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService implements IItemBusinessService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

  @Override
  public List<Item> retrieveAllItems() {
    List<ItemEntity> itemList = itemRepository.findAll();
    itemList
        .forEach(
            itemEntity -> itemEntity.setValue(itemEntity.getPrice() * itemEntity.getQuantity()));
    return itemMapper.ItemEntityListToItemList(itemList);
  }

    @Override
    public Item retrieveHardcodedItem() {
        return null;
    }


}
