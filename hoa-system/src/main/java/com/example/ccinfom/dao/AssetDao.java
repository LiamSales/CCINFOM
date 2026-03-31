package com.example.ccinfom.dao;

import com.example.ccinfom.model.Asset;
import com.example.ccinfom.mapper.AssetRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetDao {

    private final JdbcTemplate jdbcTemplate;

    public AssetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Asset> findAll() {
        String sql = "SELECT * FROM asset";
        return jdbcTemplate.query(sql, new AssetRowMapper());
    }

    public Asset findById(int assetid) {
        String sql = "SELECT * FROM asset WHERE assetid = ?";
        return jdbcTemplate.queryForObject(sql, new AssetRowMapper(), assetid);
    }

    public int insert(Asset asset) {
        String sql = """
            INSERT INTO asset
            (name, description, acq_date, forrent, value, type, status,
             location, location_mapx, location_mapy)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        return jdbcTemplate.update(sql,
                asset.getName(),
                asset.getDescription(),
                asset.getAcq_date(),
                asset.isForrent(),
                asset.getValue(),
                asset.getType(),
                asset.getStatus(),
                asset.getLocation(),
                asset.getLocation_mapx(),
                asset.getLocation_mapy()
        );
    }

    public int delete(int assetid) {
        String sql = "DELETE FROM asset WHERE assetid = ?";
        return jdbcTemplate.update(sql, assetid);
    }
}