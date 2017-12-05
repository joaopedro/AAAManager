package com.ghip.aaa.domain;

public class JwtToken {
    private String name;

    public JwtToken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
