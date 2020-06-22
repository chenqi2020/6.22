package com.chenqi.dao;

import com.chenqi.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HouseRepository extends JpaRepository<House,Integer>, JpaSpecificationExecutor {

}
