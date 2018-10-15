package com.meeting.m2.controller;

import com.meeting.m2.pojo.Areas;
import com.meeting.m2.pojo.Cities;
import com.meeting.m2.pojo.Meeting;
import com.meeting.m2.pojo.Provinces;
import com.meeting.m2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/findAreas")
    public List<Areas> findAreas(int citiesId) {
        return addressService.findAreas(citiesId);
    }

    @RequestMapping("/findCities")
    public List<Cities> findCities(int provincesId) {
        return addressService.findCities(provincesId);
    }

    @RequestMapping("/findPervince")
    public Provinces findProvinces(int provincesId) {
        return addressService.findProvinces(provincesId);
    }

    @RequestMapping("/findProvincesAll")
    public List<Provinces> findProvincesAll() {
        return addressService.findProvincesAll();
    }

    @RequestMapping("/findAreasAll")
    public List<Areas> findAreasAll() {
        return addressService.findAreasAll();
    }

    @RequestMapping("/findCitieAll")
    public List<Cities> findCitieAll() {
        return addressService.findCitieAll();
    }

}
