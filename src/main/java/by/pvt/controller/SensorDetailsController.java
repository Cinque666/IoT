package by.pvt.controller;

import by.pvt.pojo.Device;
import by.pvt.pojo.SensorValue;
import by.pvt.service.HomeService;
import by.pvt.service.SensorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/sensorDetails")
public class SensorDetailsController {

    @Autowired
    private SensorDetailsService sensorValueService;

    @Autowired
    private HomeService homeService;

    @GetMapping("/{sensor}/{id}")
    public String getSensorView(@PathVariable Long id, Model model, @PathVariable String sensor){

        model.addAttribute("sensor", sensor);

        List<Device> devices = homeService.getDevices();
        model.addAttribute("devices", devices);

        List<SensorValue> sensorValues = sensorValueService.getSensorValues(id);
        model.addAttribute("sensorValues", sensorValues);

        return "sensorDetails" ;
    }
}
