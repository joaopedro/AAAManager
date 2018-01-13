package com.ghip.aaa.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
public class ApplicationUser {

    @Id
    private String username;
    private String email;
    private String name;
    private String password;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "UserAuthority",
            joinColumns = { @JoinColumn(name = "username") },
            inverseJoinColumns = { @JoinColumn(name = "authority") }
    )
    private Collection<Authority> authorities;
    private String comment;
    @JsonIgnore
    private boolean enabled = true;

    public ApplicationUser(String username, String email, String name, String password, String comment, Collection<Authority> authorities) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.comment = comment;
        this.authorities = authorities;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}