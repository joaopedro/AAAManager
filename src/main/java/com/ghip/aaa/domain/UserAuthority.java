package com.ghip.aaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class UserAuthority {
    @Id@GeneratedValue
    private long id;
    private String name;
    @JsonIgnore
    @ManyToOne
    private ApplicationUser user;

    public UserAuthority() {}

    public UserAuthority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}
