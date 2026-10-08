package com.example.ccinfom.dao;

import com.example.ccinfom.model.AssetActivity;
import com.example.ccinfom.mapper.AssetActivityRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetActivityDao {

    private final JdbcTemplate jdbcTemplate;

    public AssetActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AssetActivity> findAll() {
        String sql = "SELECT * FROM asset_activity";
        return jdbcTemplate.query(sql, new AssetActivityRowMapper());
    }

    public int insert(AssetActivity activity) {
        String sql = """
            INSERT INTO asset_activity
            (assetid, homeownerid, orno, activity_date, description,
             sched_start, sched_end, actual_start, actual_end, status)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        return jdbcTemplate.update(sql,
                activity.getAssetid(),
                activity.getHomeownerid(),
                activity.getOrno(),
                activity.getActivity_date(),
                activity.getDescription(),
                activity.getSched_start(),
                activity.getSched_end(),
                activity.getActual_start(),
                activity.getActual_end(),
                activity.getStatus()
        );
    }
}