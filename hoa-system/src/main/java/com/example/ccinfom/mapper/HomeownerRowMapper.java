package com.example.ccinfom.mapper;

import com.example.ccinfom.model.Homeowner;
import com.example.ccinfom.model.Individual;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HomeownerRowMapper implements RowMapper<Homeowner> {

    @Override
    public Homeowner mapRow(ResultSet rs, int rowNum) throws SQLException {

        Homeowner homeowner = new Homeowner();

        homeowner.setIndividualid(rs.getInt("individualid"));
        homeowner.setLastname(rs.getString("lastname"));
        homeowner.setFirstname(rs.getString("firstname"));
        homeowner.setMi(rs.getString("mi"));
        homeowner.setEmail(rs.getString("email"));
        homeowner.setBirthday(rs.getDate("birthday").toLocalDate());
        homeowner.setGender(Individual.Gender.fromCode(rs.getString("gender").charAt(0)));
        homeowner.setFacebook_url(rs.getString("facebook_url"));
        homeowner.setPic_filename(rs.getString("pic_filename"));
        homeowner.setUndertaking(rs.getBoolean("undertaking"));
        homeowner.setResidencyStart(rs.getDate("residency_start") != null
                ? rs.getDate("residency_start").toLocalDate() : null);
        homeowner.setMembership(rs.getBoolean("membership"));
        homeowner.setResident(rs.getBoolean("isresident"));

        return homeowner;
    }
}
