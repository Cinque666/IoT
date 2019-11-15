package by.pvt.service;

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

    @Transactional
    public List<SensorValue> getSensorValues(Long id){
        return sensorValueRepository.getAllValuesBySensorId(id);
    }
}
