package web.dao;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(long id);

    User getUserByName(String name);

    void addUser(User user);

    public void updateUser(User user) throws SQLException;

    public void deleteUser(String id) throws SQLException;


}
