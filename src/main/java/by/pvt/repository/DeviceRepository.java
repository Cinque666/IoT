package by.pvt.repository;

import by.pvt.pojo.Device;
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
                .createQuery("from Device", Device.class)
                .list();
    }
}
