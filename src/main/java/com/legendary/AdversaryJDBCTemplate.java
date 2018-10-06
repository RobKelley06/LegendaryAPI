package com.legendary;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdversaryJDBCTemplate implements AdversaryDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void create(String name, Integer power) {
        String SQL = "insert into Adversary (name, power) values (?, ?)";
        jdbcTemplateObject.update( SQL, name, power);
        return;
    }
    public Adversary getAdversary(String name) {
        String SQL = "select * from Adversary where Name = ?";
        Adversary adversary = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{name}, new AdversaryMapper());

        return adversary;
    }
    public List<Adversary> listAdversaries() {
        String SQL = "select * from Adversary";
        List <Adversary> adversaries = jdbcTemplateObject.query(SQL, new AdversaryMapper());
        return adversaries;
    }
    public void delete(String name) {
        String SQL = "delete from Adversary where Name = ?";
        jdbcTemplateObject.update(SQL, name);
        return;
    }
    public void update(String name, String newName, Integer power){
        String SQL = "update Adversary set power = ?, name = ? where name = ?";
        jdbcTemplateObject.update(SQL, power, newName, name);
        return;
    }
}
