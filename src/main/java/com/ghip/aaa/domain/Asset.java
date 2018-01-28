package com.ghip.aaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Asset {
    @Id@GeneratedValue
    private long id;
    private String name;
    @JsonIgnore
    private boolean enabled = true;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.asset")
    private Set<AssetAuthority> authorities = new HashSet<AssetAuthority>(0);;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AssetAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AssetAuthority> authorities) {
        this.authorities = authorities;
    }
}
