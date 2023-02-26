package com.techelevator.dao.jdbc;

import com.techelevator.dao.GroupDao;
import com.techelevator.dao.ListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.UtilDao;
import com.techelevator.dao.exceptions.DeleteException;
import com.techelevator.dao.exceptions.GetException;
import com.techelevator.dao.exceptions.UpdateException;
import com.techelevator.model.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;

@Component
public class JdbcListDao implements ListDao {
    private final JdbcTemplate jdbcTemplate;
    private final GroupDao groupDao;
    private final UserDao userDao;
    private final UtilDao utilDao;

    public JdbcListDao(DataSource dataSource, GroupDao groupDao, UserDao userDao, UtilDao utilDao) {
        this.jdbcTemplate = new JdbcTemplate((dataSource));
        this.groupDao = groupDao;
        this.userDao = userDao;
        this.utilDao = utilDao;
    }

    @Override
    public java.util.List<List> getAllListsForGroup(int groupId) {
        java.util.List<List> lists = new ArrayList<>();
        String sql = "SELECT * FROM list where group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        while (results.next()) {
            List list = mapRowToList(results);
            lists.add(list);
        }
        return lists;
    }

    @Override
    public List getList(int groupId, int listId) {
        String sql = "SELECT * FROM list WHERE group_id = ? AND list_id = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, groupId, listId);
        try {
            if (rs.next()) {
                return mapRowToList(rs);
            }
        }
        catch (DataAccessException e) {
            throw new GetException(e);
        }
        return new List();
    }

    @Override
    public void createList(List list) {
        String sql = "INSERT INTO list (group_id, list_title, list_completed, claimed, description, date_modified) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, list.getGroupId(), list.getListName(), false, 0, list.getDescription(), utilDao.currentDay());
        } catch (DataAccessException e) {
            throw new GetException(e);
        }
    }
//    CREATE TABLE list (
//            list_id int NOT NULL DEFAULT nextval('seq_list_id'),
//    group_id int NOT NULL,
//    list_title varchar(50) NOT NULL,
//    list_completed boolean,
//    claimed int,
//    description varchar(500),
//    date_modified varchar(50) NOT NULL,
//    CONSTRAINT PK_list PRIMARY KEY (list_id),
//    CONSTRAINT FK_list_group FOREIGN KEY (group_id) REFERENCES groups (group_id)
//            );


    @Override
    public void deleteList(int groupId, int listId) {
        String sql = "DELETE FROM list WHERE group_id = ? AND list_id = ?;";
                try {
                    jdbcTemplate.update(sql, groupId, listId);
                } catch (DataAccessException e) {
                    throw new DeleteException(e);
                }
            }

    @Override
    public void claimList(int groupId, int listId, int userId) {
        String sql = "Update list set claimed = ? WHERE group_id = ? AND list_id = ?;";
        try {
            jdbcTemplate.update(sql, userId, groupId, listId);
        } catch (DataAccessException e) {
            throw new DeleteException(e);
        }
    }

    @Override
    public void unclaimList(int groupId, int listId, int userId) {
        String sql = "Update list set claimed = 0 WHERE group_id = ? AND list_id = ?;";
        try {
            jdbcTemplate.update(sql, groupId, listId);
        } catch (DataAccessException e) {
            throw new DeleteException(e);
        }
    }

    @Override
    public void updateList(List list) {
            String sql = "UPDATE list set list_title = ?, description = ?, date_modified = ? WHERE group_id = ? AND list_id = ?;";
            try {
                jdbcTemplate.update(sql, list.getListName(), list.getDescription(), utilDao.currentDay(), list.getGroupId(), list.getListId());
            } catch (DataAccessException e) {
                throw new GetException(e);
            }
        }

    @Override
    public void completeList(int groupId, int listId) {
        String sql = "UPDATE list SET list_completed = true WHERE group_id = ? AND list_id = ?;";
        try {
            jdbcTemplate.update(sql, groupId, listId);
        } catch (UpdateException e) {
            throw new UpdateException(e);
        }
    }
    @Override
    public void incompleteList(int groupId, int listId) {
        String sql = "UPDATE list SET list_completed = false WHERE group_id = ? AND list_id = ?;";
        try {
            jdbcTemplate.update(sql, groupId, listId);
        } catch (UpdateException e) {
            throw new UpdateException(e);
        }
    }

    private List mapRowToList(SqlRowSet rs) {
        List list = new List();
        list.setListId(rs.getInt("list_id"));
        list.setGroupId(rs.getInt("group_id"));
        list.setDescription(rs.getString("description"));
        list.setListName(rs.getString("list_title"));
        list.setDateModified(rs.getString("date_modified"));
        list.setClaimedId(rs.getInt("claimed"));
        list.setListCompleted(rs.getBoolean("list_completed"));
        return list;
    }
}