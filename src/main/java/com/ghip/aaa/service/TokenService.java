package com.ghip.aaa.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ghip.aaa.domain.ApplicationUser;
import com.ghip.aaa.domain.Token;
import com.ghip.aaa.domain.Authority;
import com.ghip.aaa.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import static com.ghip.aaa.security.SecurityConstants.EXPIRATION_TIME;
import static com.ghip.aaa.security.SecurityConstants.SECRET;
import static com.ghip.aaa.security.SecurityConstants.TOKEN_PREFIX;

@Service
public class TokenService {
    private TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Token generateToken(ApplicationUser user, Collection<Authority> authorities){
        try {
            String[] auths = authorities.stream().map(auth -> auth.getName() ).toArray( size -> new String[ size ] );
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String tokenId = UUID.randomUUID().toString();
            String token = JWT.create()
                    .withClaim("sub", user.getUsername())
                    .withClaim("createdAt", new Date())
                    .withClaim("jti", tokenId)
                    .withClaim("given_name", user.getName())
                    .withArrayClaim ("scopes", auths)
                    .withExpiresAt(expiresAt)
                    .sign(algorithm);
            return tokenRepository.save(new Token(tokenId,token, expiresAt, TOKEN_PREFIX));
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
            //TODO: log WRONG Encoding message
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            //TODO: log Token Signing Failed
        }
        return null;
    }

    public String getUserIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("sub").asString();
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

    public void invalidateToken(String tokenId){
        tokenRepository.delete(tokenId);
    }
}
