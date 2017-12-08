package com.ghip.aaa.domain;

import java.util.Date;


public class Token {
    private String acessToken;
    private Date expiresIn;
    private String tokenType;

    public Token(String acessToken, Date expiresIn, String tokenType) {
        this.acessToken = acessToken;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
    }


    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
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

}
