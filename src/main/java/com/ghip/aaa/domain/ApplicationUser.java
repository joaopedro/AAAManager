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
    private String role;

    public ApplicationUser(String username, String password, String comment, String role) {
        this.username = username;
        this.password = password;
        this.comment = comment;
        this.role = role;
    }

    public ApplicationUser(){}

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}