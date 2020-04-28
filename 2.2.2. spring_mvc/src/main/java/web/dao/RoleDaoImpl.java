package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.UserRole;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserRole> getAllRoles() {
        Query query=sessionFactory.getCurrentSession().createQuery("from UserRole");
        return query.getResultList();
    }

    @Override
    public UserRole getRoleBuyName(String name) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "from UserRole where role_name = '"+ name + "';");
        return (UserRole)query.getSingleResult();
    }
}
