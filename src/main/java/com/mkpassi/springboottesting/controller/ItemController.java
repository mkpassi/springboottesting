package com.mkpassi.springboottesting.controller;

import static com.mkpassi.protobuf.SpringTestingProtobuf.Item;

import com.mkpassi.springboottesting.buisness.ItemBuisnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  @Autowired
  ItemBuisnessService buisnessService;

  @RequestMapping(method = RequestMethod.GET, path = "/dummy-item")
  public Item dummyItem() {
    return Item.newBuilder().setId(1).setName("Ball").setPrice(10).setQuantity(10).build();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/item-from-business-service")
  public Item itemFromBusinessService() {
    return buisnessService.retrieveHardcodedItem();
  }
}
