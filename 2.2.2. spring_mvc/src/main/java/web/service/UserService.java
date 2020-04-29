package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;
import web.model.UserRole;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    Object getUser(long id);

    void addUser(User user);

    public void deleteUser(String id) throws SQLException;

    public void updateUser(User user) throws SQLException;

    public List<UserRole> getAllRoles();

    public UserRole getRoleByName(String name);

}
