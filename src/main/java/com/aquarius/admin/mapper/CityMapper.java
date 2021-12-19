package com.aquarius.admin.mapper;

import com.aquarius.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    City getById(Long id);

    @Insert("insert into city(`name`,`state`,`country`) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(City city);
}
