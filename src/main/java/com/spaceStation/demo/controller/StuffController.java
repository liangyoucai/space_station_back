package com.spaceStation.demo.controller;

import com.spaceStation.demo.obj.Stuff;
import com.spaceStation.demo.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/stuff")
public class StuffController {
    @Autowired
    private StuffService stuffService;
    //调用Service，返回给前端

    @RequestMapping(value = "/arr", method = RequestMethod.GET)
    public Map findAllSexP() {
        Map<String, Object> objectHashMap = new HashMap<>();
        String[] name = {"MIR", "Salyut 1","Tiangong No.3", "Salyut 7"};
        String[] data = arrayOfStuff();
        objectHashMap.put("name", name);
        objectHashMap.put("data", data);
        return objectHashMap;
    }
    public String[] arrayOfStuff(){
        String arr[] = new String[4];
        arr[0] = String.valueOf(countStuffByLoc("MIR"));
        arr[1] = String.valueOf(countStuffByLoc("SY1"));
        arr[2] = String.valueOf(countStuffByLoc("TG"));
        arr[3] = String.valueOf(countStuffByLoc("SY7"));
        return arr;
    }
    public int countStuffByLoc(String loc) {
        return stuffService.countStuffByLoc(loc);}
}
