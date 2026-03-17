package com.example.ccinfom.mapper;

import com.example.ccinfom.model.Individual;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndividualRowMapper implements RowMapper<Individual> {

    @Override
    public Individual mapRow(ResultSet rs, int rowNum) throws SQLException {

        Individual individual = new Individual();

        individual.setIndividualid(rs.getInt("individualid"));
        individual.setLastname(rs.getString("lastname"));
        individual.setFirstname(rs.getString("firstname"));
        individual.setMi(rs.getString("mi"));
        individual.setEmail(rs.getString("email"));
        individual.setBirthday(rs.getDate("birthday").toLocalDate());
        individual.setGender(rs.getString("gender"));
        individual.setFacebook_url(rs.getString("facebook_url"));
        individual.setPic_filename(rs.getString("pic_filename"));
        individual.setUndertaking(rs.getBoolean("undertaking"));

        return individual;
    }
}
