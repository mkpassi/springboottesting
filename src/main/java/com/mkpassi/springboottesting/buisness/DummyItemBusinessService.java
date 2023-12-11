package com.mkpassi.springboottesting.buisness;

import com.mkpassi.protobuf.SpringTestingProtobuf;
import com.mkpassi.protobuf.SpringTestingProtobuf.Item;
import org.springframework.stereotype.Service;

@Service
public class DummyItemBusinessService implements ItemBuisnessService{

	/** Return Hardcoded item **/
	@Override
	public Item retrieveHardcodedItem() {
		return Item.newBuilder().setId(1).setName("Ball").setPrice(10).setQuantity(10).build();
	}
}
