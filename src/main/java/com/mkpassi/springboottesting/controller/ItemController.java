package com.mkpassi.springboottesting.controller;

import static com.mkpassi.protobuf.SpringTestingProtobuf.Item;

import com.mkpassi.protobuf.SpringTestingProtobuf;
import com.mkpassi.protobuf.SpringTestingProtobuf.ItemList;
import com.mkpassi.springboottesting.service.IItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ItemController {

  @Qualifier("itemBusinessService")
  @Autowired
  IItemBusinessService itemBusinessService;

  @RequestMapping(method = RequestMethod.GET, path = "/dummy-item")
  public Item dummyItem() {
    return Item.newBuilder().setId(1).setName("Ball").setPrice(10).setQuantity(10).build();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/item-from-business-service")
  public Item itemFromBusinessService() {
    return itemBusinessService.retrieveHardcodedItem();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/all-items-from-database")
  public ItemList retrieveAllItems() {
      try{
        List<Item> items = itemBusinessService.retrieveAllItems();
        return ItemList.newBuilder().addAllItems(items).build();
      }catch (HttpMessageConversionException e){
        System.out.println("Exception: " + e.getMessage());
        e.printStackTrace();
      }
      return ItemList.newBuilder().addAllItems(Collections.emptyList()).build();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/testItem", produces = "application/json")
    public ItemList testItem() {
    Item ball = Item.newBuilder().setId(1).setName("Ball").setPrice(10).setQuantity(10).build();
    Item bat = Item.newBuilder().setId(2).setName("Bat").setPrice(20).setQuantity(20).build();
    Item gloves = Item.newBuilder().setId(3).setName("Gloves").setPrice(30).setQuantity(30).build();
    List<Item> itemList = List.of(ball, bat, gloves);
    return ItemList.newBuilder().addAllItems(itemList).build();
  }

}

