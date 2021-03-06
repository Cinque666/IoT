package by.pvt.controller;

import by.pvt.pojo.Device;
import by.pvt.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(method = RequestMethod.GET)
    public String getInformation(Model model){

        List<Device> devices = homeService.getDevices();
        model.addAttribute("devices", devices);

        return "information";
    }
}
