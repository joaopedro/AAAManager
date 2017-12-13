package com.ghip.aaa.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
public class ApplicationUser {

    @Id
    private String username;
    private String name;
    private String password;
    @OneToMany(cascade=ALL, mappedBy="user", orphanRemoval = true)
    private Collection<UserAuthority> authorities;
    private String comment;

    public ApplicationUser(String username, String name, String password, String comment, Collection<UserAuthority> authorities) {
        this.username = username;
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

    public Collection<UserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<UserAuthority> authorities) {
        this.authorities = authorities;
    }
}