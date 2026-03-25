package com.example.ccinfom.mapper;

import com.example.ccinfom.model.Homeowner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HomeownerRowMapper implements RowMapper<Homeowner> {

    @Override
    public Homeowner mapRow(ResultSet rs, int rowNum) throws SQLException {

        Homeowner homeowner = new Homeowner();

        homeowner.setHomeownerid(rs.getInt("homeownerid"));
        homeowner.setResidency_start(rs.getDate("residency_start") != null
                ? rs.getDate("residency_start").toLocalDate() : null);
        homeowner.setMembership(rs.getBoolean("membership"));
        homeowner.setIsresident(rs.getBoolean("isresident"));

        return homeowner;
    }
}
