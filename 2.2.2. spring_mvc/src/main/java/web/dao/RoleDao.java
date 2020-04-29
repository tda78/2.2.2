package web.dao;

import org.springframework.stereotype.Repository;
import web.model.UserRole;

import java.util.List;

@Repository
public interface RoleDao{
    List<UserRole> getAllRoles();
    UserRole getRoleByName(String name);

}
