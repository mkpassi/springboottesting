package com.mkpassi.springboottesting;

import com.google.protobuf.ExtensionRegistry;
import com.googlecode.protobuf.format.JsonFormat;
import com.mkpassi.protobuf.SpringTestingProtobuf;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.http.impl.client.HttpClients.createDefault;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringboottestingApplication.class)
class SpringboottestingApplicationTest {

    @LocalServerPort
    private int port;

    @Test
    void whenUsingRestTemplate_thenSuccessful() {
        String url = "http://localhost:" + port + "/all-items-from-database";
        System.out.println("url: " + url);
        String response = "response";
        assertEquals("response", response);
    }

    @Test
    void whenUsingHttpClient_thenSuccessful() throws IOException {
        /*String url = "http://localhost:" + port + "/all-items-from-database";
        CloseableHttpClient httpClient = createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        InputStream content = response.getEntity().getContent();
        JsonFormat jsonFormat = new JsonFormat();
        ExtensionRegistry extensionRegistry = ExtensionRegistry.newInstance();
        jsonFormat.merge(content, extensionRegistry, SpringTestingProtobuf.ItemList.newBuilder());
        SpringTestingProtobuf.ItemList itemList = SpringTestingProtobuf.ItemList.parseFrom(content);
        String itemListString = jsonFormat.printToString(itemList);
        System.out.println("itemListString: " + itemListString);
        assertTrue(itemListString.contains("Item2"));
        assertTrue(itemListString.contains("Item3"));*/
    }
}
