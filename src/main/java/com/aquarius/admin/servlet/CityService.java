package com.aquarius.admin.servlet;

import com.aquarius.admin.bean.City;
import com.aquarius.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/19
 * @Description:
 */
@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;
    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void addCity(City city) {
        cityMapper.insert(city);
    }
}
