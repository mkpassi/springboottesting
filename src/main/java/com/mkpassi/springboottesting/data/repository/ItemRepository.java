package com.mkpassi.springboottesting.data.repository;

import com.mkpassi.springboottesting.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {

}
