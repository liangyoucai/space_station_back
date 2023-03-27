package com.spaceStation.demo.service;

import com.spaceStation.demo.StuffMapper;
import com.spaceStation.demo.obj.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StuffService {
    @Autowired
    private StuffMapper stuffMapper;
    public int countStuffByLoc(String loc){
        return stuffMapper.countByLoc(loc);
    }
    //public List<Stuff> findStuffByName(String name) {
    //    return stuffMapper.selectByName(name);
    //}
}
