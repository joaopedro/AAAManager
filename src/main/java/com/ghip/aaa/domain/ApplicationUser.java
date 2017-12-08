package com.ghip.aaa.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationUser {

    @Id
    private String username;
    private String password;
    private String comment;

    public ApplicationUser(){}

    public ApplicationUser(String username, String password, String comment) {
        this.username = username;
        this.password = password;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}