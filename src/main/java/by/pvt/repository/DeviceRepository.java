package by.pvt.repository;

import by.pvt.pojo.Device;
import by.pvt.repository.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Device> getAllDevices(){
        return sessionFactory.getCurrentSession()
                .createQuery(Query.SELECT_FROM_DEVICE.getQuery(), Device.class)
                .setCacheable(true)
                .list();
    }

    public Device getDeviceById(Long id){
        return sessionFactory.getCurrentSession()
                .get(Device.class, id);
    }

    public List<Device> findDeviceByName(String searchDevice) {
        return sessionFactory.getCurrentSession()
                .createQuery(Query.SELECT_FROM_DEVICE_DE_WHERE_NAME_LIKE.getQuery(), Device.class)
                .setParameter("param1", "%" + searchDevice + "%")
                .list();
    }
}
