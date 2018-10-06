package com.legendary;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AdversaryMapper implements RowMapper<Adversary> {
    public Adversary mapRow(ResultSet rs, int rowNum) throws SQLException {
        Adversary adversary = new Adversary();
        adversary.setId(rs.getInt("id"));
        adversary.setName(rs.getString("name"));
        adversary.setPower(rs.getInt("power"));

        return adversary;
    }
}
