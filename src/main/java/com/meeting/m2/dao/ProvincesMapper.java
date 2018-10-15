package com.meeting.m2.dao;

import com.meeting.m2.pojo.Provinces;

import java.util.List;

public interface ProvincesMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);

    List<Provinces> findProvincesByAreasId(long areasId);

    List<Provinces> findProvincesAll();
}