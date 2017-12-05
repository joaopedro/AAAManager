package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.JwtToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateEndpoint {

    @RequestMapping("/login")
    public JwtToken generateToken(String username, String password) {

        return new JwtToken("Hello!!!!!");
    }
}
