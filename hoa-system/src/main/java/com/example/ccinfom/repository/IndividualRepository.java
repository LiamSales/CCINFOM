package com.example.ccinfom.repository;

import com.example.ccinfom.model.Individual;
import com.example.ccinfom.model.Individual.Gender;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IndividualRepository {

    private final JdbcTemplate jdbcTemplate;

    public IndividualRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
        Converts SQL row -> Individual object
    */
    private RowMapper<Individual> individualRowMapper = new RowMapper<>() {
        @Override
        public Individual mapRow(ResultSet rs, int rowNum) throws SQLException {

            Individual individual = new Individual();

            individual.setIndividualid(rs.getInt("individualid"));
            individual.setLastname(rs.getString("lastname"));
            individual.setFirstname(rs.getString("firstname"));
            individual.setMi(rs.getString("mi"));
            individual.setBirthday(rs.getDate("birthday").toLocalDate());

            char genderCode = rs.getString("gender").charAt(0);
            individual.setGender(Gender.fromCode(genderCode));

            individual.setEmail(rs.getString("email"));
            individual.setFacebook_url(rs.getString("facebook_url"));
            individual.setPicture_filename(rs.getString("pic_filename"));
            individual.setUndertaking(rs.getBoolean("undertaking"));

            return individual;
        }
    };

    /*
        CREATE
    */
    public int insertIndividual(Individual individual) {

        String sql = """
            INSERT INTO individual
            (lastname, firstname, mi, birthday, gender, email, facebook_url, pic_filename, undertaking)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        return jdbcTemplate.update(
                sql,
                individual.getLastname(),
                individual.getFirstname(),
                individual.getMi(),
                individual.getBirthday(),
                String.valueOf(individual.getGender().getCode()),
                individual.getEmail(),
                individual.getFacebook_url(),
                individual.getPicture_filename(),
                individual.isUndertaking()
        );
    }

    /*
        READ ALL
    */
    public List<Individual> findAll() {

        String sql = "SELECT * FROM individual";

        return jdbcTemplate.query(sql, individualRowMapper);
    }

    /*
        READ ONE
    */
    public Individual findById(Integer id) {

        String sql = "SELECT * FROM individual WHERE individualid = ?";

        return jdbcTemplate.queryForObject(
                sql,
                individualRowMapper,
                id
        );
    }

    /*
        UPDATE
    */
    public int updateIndividual(Individual individual) {

        String sql = """
            UPDATE individual
            SET lastname = ?,
                firstname = ?,
                mi = ?,
                birthday = ?,
                gender = ?,
                email = ?,
                facebook_url = ?,
                pic_filename = ?,
                undertaking = ?
            WHERE individualid = ?
        """;

        return jdbcTemplate.update(
                sql,
                individual.getLastname(),
                individual.getFirstname(),
                individual.getMi(),
                individual.getBirthday(),
                String.valueOf(individual.getGender().getCode()),
                individual.getEmail(),
                individual.getFacebook_url(),
                individual.getPicture_filename(),
                individual.isUndertaking(),
                individual.getIndividualid()
        );
    }

    /*
        DELETE
    */
    public int deleteIndividual(Integer id) {

        String sql = "DELETE FROM individual WHERE individualid = ?";

        return jdbcTemplate.update(sql, id);
    }
}