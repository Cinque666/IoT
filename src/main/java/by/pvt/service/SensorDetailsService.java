package by.pvt.service;

import by.pvt.pojo.Sensor;
import by.pvt.pojo.SensorValue;
import by.pvt.repository.SensorRepository;
import by.pvt.repository.SensorValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SensorDetailsService {

    @Autowired
    private SensorValueRepository sensorValueRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Transactional
    public List<SensorValue> getSensorValues(Long id, int pageId, int total){
        return sensorValueRepository.getValuesBySensorIdAndPageId(id, pageId, total);
    }

    @Transactional
    public Sensor getSensorByName(String sensor) {
        return sensorRepository.getSensorByName(sensor);
    }
}
