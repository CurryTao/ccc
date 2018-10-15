package com.meeting.m2.service;

import com.meeting.m2.pojo.Areas;
import com.meeting.m2.pojo.Cities;
import com.meeting.m2.pojo.Meeting;
import com.meeting.m2.pojo.Provinces;

import java.util.List;

public interface AddressService {


    List<Areas> findAreas(int citiesId);

    List<Cities> findCities(int provincesId);

    Provinces findProvinces(int provincesId);

    List<Provinces> findProvincesAll();

    List<Areas> findAreasAll();

    List<Cities> findCitieAll();
}
