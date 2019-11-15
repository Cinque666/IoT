package by.pvt.service;

import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import by.pvt.repository.DeviceRepository;
import by.pvt.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceDetailsService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Transactional
    public List<Device> getAllDevices(){
        return deviceRepository.getAllDevices();
    }

    @Transactional
    public Device getDevice(Long id){
        return deviceRepository.getDeviceById(id);
    }

    @Transactional
    public List<Sensor> getSensorsByDeviceId(Long id) {
        return sensorRepository.getSensorsByDeviceId(id);
    }
}
