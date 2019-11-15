package by.pvt.repository;

import by.pvt.pojo.SensorValue;
import by.pvt.repository.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SensorValueRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<SensorValue> getAllValuesBySensorId(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery(Query.SELECT_FROM_SENSORVALUE_WHERE_SENSORID.getQuery(), SensorValue.class)
                .setParameter("param", id)
                .list();
    }
}
