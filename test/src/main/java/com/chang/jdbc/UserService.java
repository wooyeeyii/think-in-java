package com.chang.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;


public class UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(User user) {
        jdbcTemplate.update("insert into user(id, name, age)values(?,?,?)",
                new Object[]{user.getId(), user.getName(), user.getAge()},
                new int[]{Types.INTEGER, Types.VARCHAR, Types.INTEGER});
    }

    public List<User> getUsers() {
        List<User> list = jdbcTemplate.query("select * from user", new UserRowMapper());
        return list;
    }

    public List<User> getUsersId1() {
        List<User> list = jdbcTemplate.query("select * from user where id=?", new Object[]{1}, new int[]{Types.INTEGER}, new UserRowMapper());
        return list;
    }
}
