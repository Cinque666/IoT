package by.pvt.controller;

import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import by.pvt.pojo.SensorValue;
import by.pvt.service.HomeService;
import by.pvt.service.SensorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sensorDetails")
public class SensorDetailsController {

    @Autowired
    private SensorDetailsService sensorDetailsService;

    @Autowired
    private HomeService homeService;

    @GetMapping("/{sensor}/{id}/{pageId}")
    public String getSensorView(@PathVariable Long id, Model model,
                                @PathVariable String sensor,
                                @PathVariable int pageId){

        int total = 10;
        if(pageId == 1) {
            // do nothing!
        } else {
            pageId= (pageId-1)*total+1;
        }

        model.addAttribute("sensor", sensor);

        List<Device> devices = homeService.getDevices();
        model.addAttribute("devices", devices);

        Sensor sensor1 = sensorDetailsService.getSensorByName(sensor);
        model.addAttribute("objSensor", sensor1);

        List<SensorValue> sensorValues = sensorDetailsService.getSensorValues(id, pageId, total);
        model.addAttribute("sensorValues", sensorValues);
        model.addAttribute("values", sensorValues);

        return "sensorDetails" ;
    }
}
