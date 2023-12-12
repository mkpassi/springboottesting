package com.mkpassi.springboottesting.mapper;

import com.mkpassi.protobuf.SpringTestingProtobuf.Item;
import com.mkpassi.springboottesting.data.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item ItemEntityToItem(ItemEntity item);
    ItemEntity ItemToItemEntity(Item item);

    List<Item> ItemEntityListToItemList(List<ItemEntity> all);
    List<ItemEntity> ItemListToItemEntityList(List<Item> all);
}
