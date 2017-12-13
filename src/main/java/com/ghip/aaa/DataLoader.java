package com.ghip.aaa;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.domain.UserAuthority;
import com.ghip.aaa.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    private ApplicationUserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public DataLoader(ApplicationUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void run(ApplicationArguments args) {
        UserAuthority adminAuth = new UserAuthority("ADMIN");
        ApplicationUser adminUser = new ApplicationUser("admin@ghip.com",
                "Administrator", bCryptPasswordEncoder.encode("123"), "Default Admin user",
                Arrays.asList(adminAuth));
        adminAuth.setUser(adminUser);

        userRepository.save(adminUser);

        UserAuthority userAuth = new UserAuthority("USER");
        ApplicationUser user1 = new ApplicationUser("user1@ghip.com",
                "ApplicationUser One", bCryptPasswordEncoder.encode("password"), "Default non Admin user",
                Arrays.asList(userAuth));
        userAuth.setUser(user1);
        userRepository.save(user1);

        UserAuthority adminAuth2 = new UserAuthority("ADMIN");
        UserAuthority userAuth2 = new UserAuthority("USER");
        ApplicationUser user2 = new ApplicationUser("user2@ghip.com",
                "ApplicationUser Two", bCryptPasswordEncoder.encode("password"), "Default ApplicationUser with Admin and ApplicationUser",
                Arrays.asList(adminAuth2, userAuth2));
        adminAuth2.setUser(user2);
        userAuth2.setUser(user2);
        userRepository.save(user2);
    }
}