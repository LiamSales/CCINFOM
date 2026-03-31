package com.example.ccinfom.dao;

import com.example.ccinfom.mapper.PropertyRowMapper;
import com.example.ccinfom.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertyDao {

    private final JdbcTemplate jdbcTemplate;

    public PropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Property> findAll() {
        return jdbcTemplate.query("SELECT * FROM property", new PropertyRowMapper());
    }

    public Property findById(String propertycode) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM property WHERE propertycode = ?",
                new PropertyRowMapper(),
                propertycode
        );
    }

    public int insert(Property property) {

        String sql = """
                INSERT INTO property
                (propertycode, homeownerid, size, turnover_date)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(sql,
                property.getPropertycode(),
                property.getHomeownerid(),
                property.getSize(),
                property.getTurnover_date()
        );
    }

    public int delete(String propertycode) {
        return jdbcTemplate.update(
                "DELETE FROM property WHERE propertycode = ?",
                propertycode
        );
    }
}
