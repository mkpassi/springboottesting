package com.mkpassi.springboottesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.mkpassi.protobuf.SpringTestingProtobuf.Item;
import com.mkpassi.springboottesting.buisness.ItemBuisnessService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ItemBuisnessService buisnessService;


  @Test
  void testDummyItem() throws Exception {
    RequestBuilder request =
        MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
    MvcResult result =
        mockMvc
            .perform(request)
            .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
            .andReturn();

    JSONAssert.assertEquals(
        "{\"id\":1,\"name\":\"Ball\",\"price\":10}",
        result.getResponse().getContentAsString(),
        false);
  }

  @Test
  void testItemFromBusinessService() throws Exception {

    when(buisnessService.retrieveHardcodedItem())
        .thenReturn(
            Item.newBuilder().setId(1).setName("Ball").setPrice(10).setQuantity(10).build());
	RequestBuilder request =
			MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
    MvcResult result =
        mockMvc
            .perform(request)
            .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
            .andReturn();
	JSONAssert.assertEquals(
			"{\"id\":1,\"name\":\"Ball\",\"price\":10}",
			result.getResponse().getContentAsString(),
			false);
  }
}
