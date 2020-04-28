package web.dao;

import web.model.UserRole;

import java.util.List;

public interface RoleDao {
    List<UserRole> getAllRoles();
    UserRole getRoleBuyName(String name);

}