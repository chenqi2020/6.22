package com.chenqi.service.impl;


import com.chenqi.dao.DistrictRepostory;
import com.chenqi.entity.District;
import com.chenqi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
   @Autowired
   private DistrictRepostory districtRepostory;
    @Override
    public Object getList() {
        List<District> all = districtRepostory.findAll();
        List<District> provinceList = districtRepostory.findByPid(1);
        provinceList.forEach(province->{
            List<District> cityList=new ArrayList<>();
            all.forEach(city->{
                if (province.getId().intValue()==city.getPid().intValue()){
                    cityList.add(city);
                    List<District> countryList=new ArrayList<>();
                    all.forEach(country->{
                        if (city.getId().intValue()==country.getPid().intValue()){
                            countryList.add(country);
                        }
                    });
                    city.setDistrictList(countryList);
                }
            });
            province.setDistrictList(cityList);
        });
        return provinceList;
    }

    @Override
    public Object getListByPid() {
        return districtRepostory.findByPid(40);
    }
}
