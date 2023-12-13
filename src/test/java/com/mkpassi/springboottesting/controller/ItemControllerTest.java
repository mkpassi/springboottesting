package com.mkpassi.springboottesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mkpassi.protobuf.SpringTestingProtobuf.Item;
import com.mkpassi.springboottesting.service.interfaces.IItemBusinessService;
import java.util.List;
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

  @MockBean(name = "itemBusinessService")
  private IItemBusinessService buisnessService;

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
        MockMvcRequestBuilders.get("/item-from-business-service")
            .accept(MediaType.APPLICATION_JSON);
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
  void testAllItemsFromDatabase() throws Exception {
    Item ball = Item.newBuilder().setId(1).setName("Ball").setPrice(10).setQuantity(10).build();
    Item bat = Item.newBuilder().setId(2).setName("Bat").setPrice(20).setQuantity(20).build();
    Item gloves = Item.newBuilder().setId(3).setName("Gloves").setPrice(30).setQuantity(30).build();
    List<Item> itemList = List.of(ball, bat, gloves);
    when(buisnessService.retrieveAllItems()).thenReturn(itemList);
    RequestBuilder request =
        MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON);
    MvcResult result =
        mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(
                content()
                    .json(
                        "{\"items\":[{\"id\":1,\"name\":\"Ball\",\"price\":10},{\"id\":2,\"name\":\"Bat\",\"price\":20},{\"id\":3,\"name\":\"Gloves\",\"price\":30}]}"))
            .andReturn();
  }
}
