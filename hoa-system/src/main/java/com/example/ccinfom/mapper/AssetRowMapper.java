package com.example.ccinfom.mapper;

import com.example.ccinfom.model.Asset;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssetRowMapper implements RowMapper<Asset> {

    @Override
    public Asset mapRow(ResultSet rs, int rowNum) throws SQLException {

        Asset a = new Asset();

        a.setAssetid(rs.getInt("assetid"));
        a.setName(rs.getString("name"));
        a.setDescription(rs.getString("description"));
        a.setAcq_date(rs.getDate("acq_date").toLocalDate());
        a.setForrent(rs.getBoolean("forrent"));
        a.setValue(rs.getFloat("value"));
        a.setType(rs.getString("type"));
        a.setStatus(rs.getString("status"));
        a.setLocation(rs.getString("location"));
        a.setLocation_mapx(rs.getString("location_mapx"));
        a.setLocation_mapy(rs.getString("location_mapy"));

        return a;
    }
}