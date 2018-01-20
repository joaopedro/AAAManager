package com.ghip.aaa.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssetAuthorityId implements Serializable{
    @ManyToOne
    private Asset asset;
    @ManyToOne
    private Authority authority;

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetAuthorityId that = (AssetAuthorityId) o;
        return Objects.equals(getAsset(), that.getAsset()) &&
                Objects.equals(getAuthority(), that.getAuthority());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAsset(), getAuthority());
    }
}
