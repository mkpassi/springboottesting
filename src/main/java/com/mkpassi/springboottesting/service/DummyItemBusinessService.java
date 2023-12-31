package com.mkpassi.springboottesting.service;

import com.mkpassi.protobuf.SpringTestingProtobuf.Item;
import com.mkpassi.springboottesting.service.interfaces.IItemBusinessService;
import org.springframework.stereotype.Service;

@Service
public class DummyItemBusinessService implements IItemBusinessService {

	/** Return Hardcoded item **/
	@Override
	public Item retrieveHardcodedItem() {
		return Item.newBuilder().setId(1).setName("Ball").setPrice(10).setQuantity(10).build();
	}
}
