package by.pvt.repository;

import by.pvt.pojo.ApplicationUser;
import by.pvt.repository.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(ApplicationUser user) {
        sessionFactory.getCurrentSession()
                .save(user);
    }

    public Integer findUserCountByLogin(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery(Query.SELECT_FROM_APPLICATIONUSER_WHERE_USERNAME.getQuery(), ApplicationUser.class)
                .setParameter("param1", username)
                .list()
                .size();
    }
}
