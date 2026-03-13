package com.example.ccinfom.dao;

import com.example.ccinfom.model.Resident;
import com.example.ccinfom.mapper.ResidentRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResidentDao {

    private final JdbcTemplate jdbcTemplate;

    public ResidentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Resident> findAll() {

        String sql = "SELECT * FROM resident";

        return jdbcTemplate.query(sql, new ResidentRowMapper());
    }

    public Resident findById(int residentid) {

        String sql = "SELECT * FROM resident WHERE residentid = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new ResidentRowMapper(),
                residentid
        );
    }

    public int insert(Resident resident) {

        String sql = """
                INSERT INTO resident
                (residentid, renter, rel_homeowner, authorized, last_update)
                VALUES (?, ?, ?, ?, ?)
                """;

        return jdbcTemplate.update(sql,
                resident.getResidentid(),
                resident.isRenter(),
                resident.getRel_homeowner(),
                resident.isAuthorized(),
                resident.getLast_update()
        );
    }

    public int delete(int residentid) {

        String sql = "DELETE FROM resident WHERE residentid = ?";

        return jdbcTemplate.update(sql, residentid);
    }
}