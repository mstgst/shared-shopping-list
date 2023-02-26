package com.techelevator.dao.jdbc;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.UtilDao;
import com.techelevator.model.GroupMember;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class JdbcUtilDao implements UtilDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;
    public JdbcUtilDao(DataSource dataSource, UserDao userDao) {
        this.jdbcTemplate = new JdbcTemplate((dataSource));
        this.userDao = userDao;
    }
    @Override
    public boolean isVerified(String username, int groupId) {
        int memberId = userDao.findIdByUsername(username);
        String sql = "SELECT * FROM group_member WHERE user_id = ? AND group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, memberId, groupId);
        return results.next();
    }

    @Override
    public String currentDay(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = now.toString();
        return date;
    }
}
