package web.service;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(long id);
    void addUser(User user);
    public void deleteUser(String id) throws SQLException;

    public void updateUser(User user) throws SQLException;

}
