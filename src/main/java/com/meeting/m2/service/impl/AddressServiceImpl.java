package com.meeting.m2.service.impl;


import com.meeting.m2.dao.AreasMapper;
import com.meeting.m2.dao.CitiesMapper;
import com.meeting.m2.dao.MeetingMapper;
import com.meeting.m2.dao.ProvincesMapper;
import com.meeting.m2.pojo.Areas;
import com.meeting.m2.pojo.Cities;
import com.meeting.m2.pojo.Meeting;
import com.meeting.m2.pojo.Provinces;
import com.meeting.m2.service.AddressService;
import com.meeting.m2.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AreasMapper areasMapper;

    @Autowired
    private CitiesMapper citiesMapper;

    @Autowired
    private ProvincesMapper provincesMapper;

    @Override
    public List<Areas> findAreas(int citiesId) {
        return areasMapper.findAreasByCitiesId(citiesId);
    }

    @Override
    public List<Cities> findCities(int provincesId) {
        return citiesMapper.findCitiesByProvincesId(provincesId);
    }

    @Override
    public Provinces findProvinces(int provincesId) {
        return provincesMapper.selectByPrimaryKey(provincesId);
    }

    @Override
    public List<Provinces> findProvincesAll() {
        return provincesMapper.findProvincesAll();
    }

    @Override
    public List<Areas> findAreasAll() {
        return areasMapper.findAreasAll();
    }

    @Override
    public List<Cities> findCitieAll() {
        return citiesMapper.findCitieAll();
    }
}
