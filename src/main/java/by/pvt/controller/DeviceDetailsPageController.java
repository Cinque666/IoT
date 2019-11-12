package by.pvt.controller;

import by.pvt.pojo.Device;
import by.pvt.service.DeviceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/deviceDetails")
public class DeviceDetailsPageController {

    @Autowired
    private DeviceDetailsService deviceDetailsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getDeviceDetails(Model model){

        List<Device> devices = deviceDetailsService.getDevices();
        model.addAttribute("devices", devices);

        return "deviceDetails";
    }
}
