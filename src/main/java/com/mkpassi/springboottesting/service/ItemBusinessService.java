package com.mkpassi.springboottesting.service;

import com.mkpassi.protobuf.SpringTestingProtobuf;
import com.mkpassi.protobuf.SpringTestingProtobuf.Item;
import com.mkpassi.springboottesting.data.entity.ItemEntity;
import com.mkpassi.springboottesting.data.repository.ItemRepository;
import com.mkpassi.springboottesting.mapper.ItemMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService implements IItemBusinessService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Item> retrieveAllItems() {
        List<ItemEntity> itemList = itemRepository.findAll();
       // log.info("itemList: {}", itemList);
        return itemMapper.ItemEntityListToItemList(itemList);
    }

    @Override
    public Item retrieveHardcodedItem() {
        return null;
    }


}