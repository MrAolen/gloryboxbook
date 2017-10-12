package fr.gunther.glorybox.website.configuration;

import fr.gunther.glorybox.website.entity.User;
import fr.gunther.glorybox.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class InitConfig {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initData() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");

        User user = new User();
        user.setEmail("gunthernic@eisti.eu");
        user.setActive(1);
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

}
