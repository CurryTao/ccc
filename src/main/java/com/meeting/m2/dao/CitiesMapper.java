package com.meeting.m2.dao;

import com.meeting.m2.pojo.Cities;

import java.util.List;

public interface CitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cities record);

    int insertSelective(Cities record);

    Cities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);

    List<Cities> findCitiesByProvincesId(long provincesId);

    List<Cities> findCitieAll();
}