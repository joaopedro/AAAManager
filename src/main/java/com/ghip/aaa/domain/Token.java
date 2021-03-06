package com.ghip.aaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Token {
    @JsonIgnore
    @Id
    private String tokenId;

    private String accessToken;
    private Date expiresIn;
    private String tokenType;

    public Token(){}

    public Token(String tokenId, String acessToken, Date expiresIn, String tokenType) {
        this.tokenId = tokenId;
        this.accessToken = acessToken;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
    }


    public String getAcessToken() {
        return accessToken;
    }

    public void setAcessToken(String acessToken) {
        this.accessToken = acessToken;
    }

    public Date getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
