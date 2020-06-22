package com.chenqi.dao;


import com.chenqi.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepostory extends JpaRepository<District,Integer> {
    //根据pid查询地区
    List<District> findByPid(Integer pid);
}
