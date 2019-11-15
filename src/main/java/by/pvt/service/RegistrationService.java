package by.pvt.service;

import by.pvt.pojo.ApplicationUser;
import by.pvt.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean save(ApplicationUser user) {

        if(user == null || user.getName().isEmpty() || user.getPassword().isEmpty() || user.getUserName().isEmpty()){
            return false;
        }

        Integer userCountByLogin = applicationUserRepository.findUserCountByLogin(user.getUserName());
        if (userCountByLogin != null && userCountByLogin >= 1) {
            return false;
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        applicationUserRepository.save(user);

        return true;
    }
}
