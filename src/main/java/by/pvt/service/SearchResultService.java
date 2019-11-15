package by.pvt.service;

import by.pvt.pojo.Device;
import by.pvt.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class SearchResultService {

    @Autowired
    private DeviceRepository deviceRepository;


    @Transactional
    public List<Device> searchDevice(String searchDevice) {

        if (searchDevice == null || searchDevice.isEmpty()) {
            return Collections.emptyList();
        }
        return deviceRepository.findDeviceByName(searchDevice);
    }
}
