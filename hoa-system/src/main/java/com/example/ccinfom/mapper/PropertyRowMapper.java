package com.example.ccinfom.mapper;

import com.example.ccinfom.model.Property;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyRowMapper implements RowMapper<Property> {

    @Override
    public Property mapRow(ResultSet rs, int rowNum) throws SQLException {

        Property property = new Property();

        property.setPropertycode(rs.getString("propertycode"));
        property.setHomeownerid(rs.getInt("homeownerid"));
        property.setSize(rs.getInt("size"));
        property.setTurnover_date(rs.getDate("turnover_date").toLocalDate());

        return property;
    }
}
