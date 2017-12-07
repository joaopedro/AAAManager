package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.domain.Token;
import com.ghip.aaa.repository.ApplicationUserRepository;
import com.ghip.aaa.service.TokenService;
import com.ghip.aaa.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserDetailsServiceImpl userDetailsService;
    private TokenService tokenService;

    @Autowired
    public TokenController(ApplicationUserRepository applicationUserRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsServiceImpl, TokenService tokenService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsServiceImpl;
        this.tokenService = tokenService;
    }
    @PostMapping("/generate")
    public Token generateToken(@RequestBody ApplicationUser user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        if(bCryptPasswordEncoder.encode(user.getPassword()).equals(userDetails.getPassword())){
            return tokenService.generateToken(userDetails.getUsername());
        }else{
            throw  new RuntimeException("Cannot Generate Token");
        }
    }
}