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
}
