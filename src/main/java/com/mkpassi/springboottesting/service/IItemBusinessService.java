package com.mkpassi.springboottesting.service;

import com.mkpassi.protobuf.SpringTestingProtobuf;

import java.util.List;

public interface IItemBusinessService {

	default List<SpringTestingProtobuf.Item> retrieveAllItems() {
		throw new UnsupportedOperationException("Not implemented yet");
	}
	SpringTestingProtobuf.Item retrieveHardcodedItem();
}
