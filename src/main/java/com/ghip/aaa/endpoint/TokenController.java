package com.ghip.aaa.endpoint;

import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.domain.Token;
import com.ghip.aaa.repository.ApplicationUserRepository;
import com.ghip.aaa.exceptions.UsernamePasswordException;
import com.ghip.aaa.service.TokenService;
import com.ghip.aaa.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    public Token generateToken(@RequestBody ApplicationUser applicationUser) {
        ApplicationUser userDetails = applicationUserRepository.getOne(applicationUser.getUsername());
        if(bCryptPasswordEncoder.matches(applicationUser.getPassword(),userDetails.getPassword())){
            return tokenService.generateToken(userDetails, userDetails.getAuthorities());
        }else{
            throw new UsernamePasswordException("Password does not match");
        }
    }

    @PostMapping("/invalidate/{tokenId}")
    public void invalidate(@PathVariable String tokenId) {
        tokenService.invalidateToken(tokenId);
    }

}