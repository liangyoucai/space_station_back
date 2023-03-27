package com.spaceStation.demo;

import com.spaceStation.demo.obj.Stuff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface StuffMapper {
    //List<Stuff> selectByName(@Param("name") String name);
    int countByLoc(@Param("loc") String loc);
}
