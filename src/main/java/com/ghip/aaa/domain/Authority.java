package com.ghip.aaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority {
    @Id@GeneratedValue
    private long id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "authorities")
    private Collection<ApplicationUser> users;
//    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
    @OneToMany(mappedBy = "pk.authority", cascade=CascadeType.ALL)
    private Set<AssetAuthority> assetAuthorities = new HashSet<AssetAuthority>(0);
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

    public Collection<ApplicationUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<ApplicationUser> users) {
        this.users = users;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AssetAuthority> getAssetAuthorities() {
        return assetAuthorities;
    }

    public void setAssetAuthorities(Set<AssetAuthority> assetAuthorities) {
        this.assetAuthorities = assetAuthorities;
    }
}
