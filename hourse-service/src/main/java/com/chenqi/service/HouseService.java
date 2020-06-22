package com.chenqi.service;

import com.chenqi.entity.House;
import org.springframework.data.domain.Page;

public interface HouseService {
    //列表
    Page list(Integer pageNum, Integer pageSize, House house, Integer rentSearch);
    //添加  and  修改
    boolean saveOrUpdate(House house);
    //删除  批量删除
    boolean delete(Integer[] ids);

}
