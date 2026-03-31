package com.example.ccinfom.mapper;

import com.example.ccinfom.model.AssetActivity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssetActivityRowMapper implements RowMapper<AssetActivity> {

    @Override
    public AssetActivity mapRow(ResultSet rs, int rowNum) throws SQLException {

        AssetActivity a = new AssetActivity();

        a.setActivityid(rs.getInt("activityid"));
        a.setAssetid(rs.getInt("assetid"));
        a.setHomeownerid(rs.getInt("homeownerid"));
        a.setOrno(rs.getInt("orno"));
        a.setActivity_date(rs.getDate("activity_date").toLocalDate());
        a.setDescription(rs.getString("description"));

        if (rs.getDate("sched_start") != null)
            a.setSched_start(rs.getDate("sched_start").toLocalDate());

        if (rs.getDate("sched_end") != null)
            a.setSched_end(rs.getDate("sched_end").toLocalDate());

        a.setStatus(rs.getString("status"));

        return a;
    }
}