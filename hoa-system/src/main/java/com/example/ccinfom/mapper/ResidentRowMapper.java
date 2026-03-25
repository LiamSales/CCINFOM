package com.example.ccinfom.mapper;

import com.example.ccinfom.model.Resident;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ResidentRowMapper implements RowMapper<Resident> {

    @Override
    public Resident mapRow(ResultSet rs, int rowNum) throws SQLException {

        Resident resident = new Resident();

        resident.setResidentid(rs.getInt("residentid"));
        resident.setRenter(rs.getBoolean("renter"));
        resident.setRel_homeowner(rs.getString("rel_homeowner"));
        resident.setAuthorized(rs.getBoolean("authorized"));

        if (rs.getTimestamp("last_update") != null) {
            resident.setLast_update(rs.getTimestamp("last_update").toLocalDateTime());
        }

        return resident;
    }
}
