package com.aquarius.admin.servlet.impl;

import com.aquarius.admin.bean.City;
import com.aquarius.admin.mapper.CityMapper;
import com.aquarius.admin.servlet.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/19
 * @Description:
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;
    @Override
    public City getById(Long id){
        return cityMapper.getById(id);
    }

    @Override
    public void addCity(City city) {
        cityMapper.insert(city);
    }
}
