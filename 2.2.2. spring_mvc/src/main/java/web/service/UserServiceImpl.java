package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.User;
import web.model.UserRole;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public Object getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(String id) throws SQLException {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public List<UserRole> getAllRoles() {
        return roleDao.getAllRoles();
    }
    @Transactional
    @Override
    public UserRole getRoleByName(String name) {
        return roleDao.getRoleBuyName(name);
    }

}
