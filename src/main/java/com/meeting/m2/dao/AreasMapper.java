package com.meeting.m2.dao;

import com.meeting.m2.pojo.Areas;

import java.util.List;

public interface AreasMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Areas record);

    int insertSelective(Areas record);

    Areas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Areas record);

    int updateByPrimaryKey(Areas record);

    List<Areas> findAreasByCitiesId(long citiesId);

    List<Areas> findAreasAll();
}