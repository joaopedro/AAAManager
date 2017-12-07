package com.ghip.aaa.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ghip.aaa.domain.Token;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static com.ghip.aaa.security.SecurityConstants.EXPIRATION_TIME;
import static com.ghip.aaa.security.SecurityConstants.SECRET;
import static com.ghip.aaa.security.SecurityConstants.TOKEN_PREFIX;

@Service
public class TokenService {

    public Token generateToken(String username){
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String token = JWT.create()
                    .withClaim("userId", username)
                    .withClaim("createdAt", new Date())
                    .withExpiresAt(expiresAt)
                    .sign(algorithm);
            return new Token(token, expiresAt, TOKEN_PREFIX);
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
            //TODO: log WRONG Encoding message
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            //TODOD: log Token Signing Failed
        }
        return null;
    }

    public String getUserIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("userId").asString();
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
            //TODO: log WRONG Encoding message
            return null;
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
            //TODO: log Token Verification Failed
            return null;
        }
    }

    public boolean isTokenValid(String token) {
        String userId = this.getUserIdFromToken(token);
        return userId != null;
    }
}
