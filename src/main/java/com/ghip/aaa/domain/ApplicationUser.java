package com.ghip.aaa.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class ApplicationUser {

    @Id
    private String username;
    private String name;
    private String password;
    private List<String> role;
    private String comment;

    public ApplicationUser(String username, String name, String password, String comment, List<String> role) {
        this.username = username;
        this.name = name;
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

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}