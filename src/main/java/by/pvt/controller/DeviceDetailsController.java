package by.pvt.controller;

import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import by.pvt.service.DeviceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/deviceDetails")
public class DeviceDetailsController {

    @Autowired
    private DeviceDetailsService deviceDetailsService;

    @GetMapping("/device/{id}")
    public String getDeviceDetails(@PathVariable Long id, Model model){

        Device device = deviceDetailsService.getDevice(id);
        List<Device> devices = deviceDetailsService.getAllDevices();
        List<Sensor> sensors = deviceDetailsService.getSensorsByDeviceId(id);

        model.addAttribute("device", device);
        model.addAttribute("devices", devices);
        model.addAttribute("sensors", sensors);

        return "deviceDetails";
    }
}
