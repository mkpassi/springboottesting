package com.mkpassi.springboottesting.data.repository;

import com.mkpassi.springboottesting.data.entity.ItemEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ItemRepositoryTest {


    @Autowired
    ItemRepository itemRepository;
    @Test
    public void testFindAll() {
        List<ItemEntity> itemEntities = itemRepository.findAll();
        assertEquals(7,itemEntities.size());
    }

}
