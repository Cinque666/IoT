package by.pvt.repository;

import by.pvt.pojo.Sensor;
import by.pvt.repository.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SensorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Sensor> getSensorsByDeviceId(Long deviceId) {
        return sessionFactory.getCurrentSession()
                .createQuery(Query.SELECT_FROM_SENSOR_WHERE_DEVICEID.getQuery(), Sensor.class)
                .setParameter("param", deviceId)
                .list();
    }
}
