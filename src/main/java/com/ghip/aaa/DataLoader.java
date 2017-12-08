package com.ghip.aaa;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

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
        userRepository.save(new ApplicationUser("Admin",
                bCryptPasswordEncoder.encode("123"), "lala"));
    }
}