package com.example.ccinfom.dao;

import com.example.ccinfom.model.Individual;
import com.example.ccinfom.mapper.IndividualRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndividualDao {

    private final JdbcTemplate jdbcTemplate;

    public IndividualDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Individual> findAll() {

        String sql = "SELECT * FROM individual";

        return jdbcTemplate.query(sql, new IndividualRowMapper());
    }

    public Individual findById(int individualid) {

        String sql = "SELECT * FROM individual WHERE individualid = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new IndividualRowMapper(),
                individualid
        );
    }

    public int insert(Individual individual) {

        String sql = """
                INSERT INTO individual
                (lastname, firstname, mi, email, birthday, gender,
                 facebook_url, pic_filename, undertaking)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        return jdbcTemplate.update(sql,
                individual.getLastname(),
                individual.getFirstname(),
                individual.getMi(),
                individual.getEmail(),
                individual.getBirthday(),
                individual.getGender(),
                individual.getFacebook_url(),
                individual.getPic_filename(),
                individual.isUndertaking()
        );
    }

    public int delete(int individualid) {

        String sql = "DELETE FROM individual WHERE individualid = ?";

        return jdbcTemplate.update(sql, individualid);
    }
}