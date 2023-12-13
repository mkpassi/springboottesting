package com.mkpassi.springboottesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerIntegrationTest {

    @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void contextLoads() throws JSONException {
    String response = testRestTemplate.getForObject("/all-items-from-database", String.class);
    JSONAssert.assertEquals(
            """
                    {
                      "items": [{
                        "id": 1
                      }, {
                        "id": 2
                      }, {
                        "id": 3
                      }, {
                        "id": 4
                      }, {
                        "id": 5
                      }, {
                        "id": 6
                      }, {
                        "id": 7
                      }]
                    }""",
        response,
        false);
    assertTrue(response.contains("Item2"));
    assertTrue(response.contains("Item3"));
  }
}
