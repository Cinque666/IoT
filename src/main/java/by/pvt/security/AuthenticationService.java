package by.pvt.security;

import by.pvt.pojo.ApplicationUser;
import by.pvt.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username){

        ApplicationUser user = appUserRepository.findUserByLogin(username);

        if(user == null){
            throw new UsernameNotFoundException("Username " + username + "not found");
        }

        String role = "ROLE_" + user.getRole();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}
