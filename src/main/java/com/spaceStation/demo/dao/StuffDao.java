package com.spaceStation.demo.dao;

import com.spaceStation.demo.obj.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StuffDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Stuff> findAll() {
        String sql = "SELECT * FROM stuff";
        return jdbcTemplate.query(sql, new StuffRowMapper());
    }
    //查询每个空间站的人数
    public int countByloc(String loc){
        String sql = "SELECT COUNT(*) FROM stuff WHERE sloc = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, loc);
    }

    public Stuff findById(Long id) {
        String sql = "SELECT * FROM stuff WHERE sid = ?";
        return jdbcTemplate.queryForObject(sql, new StuffRowMapper(), id);
    }

    private static class StuffRowMapper implements RowMapper<Stuff> {
        @Override
        public Stuff mapRow(ResultSet rs, int rowNum) throws SQLException {
            Stuff stuff = new Stuff();
            stuff.setSid(rs.getLong("sid"));
            stuff.setSname(rs.getString("sname"));
            stuff.setSloc(rs.getString("sloc"));
            stuff.setSsex(rs.getString("ssex"));
            return stuff;
        }
    }
}
