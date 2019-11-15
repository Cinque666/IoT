package by.pvt.controller;

import by.pvt.pojo.ApplicationUser;
import by.pvt.pojo.Device;
import by.pvt.repository.Role;
import by.pvt.service.HomeService;
import by.pvt.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private HomeService homeService;

    @GetMapping
    public String getRegisterView(Model model){

        List<String> roles = new ArrayList<>();
        roles.add(Role.ADMIN.getRole());
        roles.add(Role.ANALYST.getRole());

        model.addAttribute("roles", roles);

        List<Device> devices = homeService.getDevices();
        model.addAttribute("devices", devices);

        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute ApplicationUser user, Model model){

        if(!registrationService.save(user)){
            return "error";
        }

        List<Device> devices = homeService.getDevices();
        model.addAttribute("devices", devices);

        return "registration";
    }
}
