package com.aquarius.admin.servlet;

import com.aquarius.admin.bean.City;

public interface CityService {

    public City getById(Long id);

    public void addCity(City city);
}
