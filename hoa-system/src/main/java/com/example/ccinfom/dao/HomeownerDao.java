package com.example.ccinfom.dao;

import com.example.ccinfom.model.Homeowner;
import com.example.ccinfom.mapper.HomeownerRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeownerDao {

    private final JdbcTemplate jdbcTemplate;

    public HomeownerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Homeowner> findAll() {

        String sql = """
                SELECT i.*, h.residency_start, h.membership, h.isresident
                FROM homeowner h
                JOIN individual i ON i.individualid = h.homeownerid
                """;

        return jdbcTemplate.query(sql, new HomeownerRowMapper());
    }

    public Homeowner findById(int homeownerid) {

        String sql = """
                SELECT i.*, h.residency_start, h.membership, h.isresident
                FROM homeowner h
                JOIN individual i ON i.individualid = h.homeownerid
                WHERE h.homeownerid = ?
                """;

        return jdbcTemplate.query(sql, new HomeownerRowMapper(), homeownerid)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public int insert(Homeowner homeowner) {

        String sql = """
                INSERT INTO homeowner
                (homeownerid, residency_start, membership, isresident)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(sql,
                homeowner.getIndividualid(),
                homeowner.getResidencyStart(),
                homeowner.isMembership(),
                homeowner.isResident()
        );
    }

    public int delete(int homeownerid) {

        String sql = "DELETE FROM homeowner WHERE homeownerid = ?";

        return jdbcTemplate.update(sql, homeownerid);
    }
}