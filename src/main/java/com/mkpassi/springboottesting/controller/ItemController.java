package com.mkpassi.springboottesting.controller;

import static com.mkpassi.protobuf.SpringTestingProtobuf.Item;

import com.mkpassi.springboottesting.service.IItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
  public List<Item> retrieveAllItems() {
      return itemBusinessService.retrieveAllItems();
  }

}
