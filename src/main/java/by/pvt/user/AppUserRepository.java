package by.pvt.user;

import by.pvt.pojo.ApplicationUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public ApplicationUser findUserByLogin(String username) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from ApplicationUser where username like :param1", ApplicationUser.class)
                    .setParameter("param1", username)
                    .getSingleResult();
        } catch (Exception e) {
//            log.warning(e.getMessage());
            return null;
        }
    }
}
