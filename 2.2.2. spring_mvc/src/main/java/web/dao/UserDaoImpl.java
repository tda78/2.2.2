package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public Object getUser(long id) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "from User where user_id = "+ id);
        return query.getSingleResult();
    }

    @Override
    public Object getUserByName(String name) {
        Query query=sessionFactory.getCurrentSession().createQuery(
            "from User where user_name = '"+ name + "';");
        return query.getSingleResult();

    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(String id) throws SQLException {
        Object user = getUser(Long.parseLong(id));
        sessionFactory.getCurrentSession().delete(user);
    }
}
