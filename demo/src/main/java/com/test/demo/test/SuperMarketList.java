package com.test.demo.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperMarketList extends JpaRepository<SuperMarket,Integer> {
}
