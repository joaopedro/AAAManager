package com.ghip.aaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Authority {
    @Id@GeneratedValue
    private long id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "authorities")
    private Collection<ApplicationUser> user;
    @JsonIgnore
    private boolean enabled = true;

    public Authority() {}

    public Authority(String name) {
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

    public Collection<ApplicationUser> getUser() {
        return user;
    }

    public void setUser(Collection<ApplicationUser> user) {
        this.user = user;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
