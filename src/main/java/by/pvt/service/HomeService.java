package by.pvt.service;

import by.pvt.pojo.Device;
import by.pvt.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Transactional
    public List<Device> getDevices(){
        return deviceRepository.getAllDevices();
    }
}
