package by.pvt.controller;

import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import by.pvt.service.DeviceDetailsService;
import by.pvt.service.HomeService;
import by.pvt.service.SearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchResultController {

    @Autowired
    private SearchResultService searchResultService;

    @Autowired
    private HomeService homeService;

    @Autowired
    private DeviceDetailsService deviceDetailsService;

    @GetMapping
    public String getSearchResult(@RequestParam String searchDevice, Model model){

        List<Device> searchDevices = searchResultService.searchDevice(searchDevice);

        if(searchDevice.isEmpty()){
            return "error";
        }
        model.addAttribute("searchDevices", searchDevices);

        Long id = searchDevices.get(0).getId();
        List<Sensor> sensors = deviceDetailsService.getSensorsByDeviceId(id);

        if(sensors.isEmpty()){
            return "error";
        }
        model.addAttribute("sensors", sensors);

        List<Device> devices = homeService.getDevices();

        if(devices.isEmpty()){
            return "error";
        }

        model.addAttribute("devices", devices);

        return "searchResult";
    }
}
