package com.ghip.aaa.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class AssetAuthority {
    @EmbeddedId
    private AssetAuthorityId pk = new AssetAuthorityId();
    private boolean read;
    private boolean write;
    private boolean delete;

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public AssetAuthorityId getPk() {
        return pk;
    }

    public void setPk(AssetAuthorityId pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetAuthority)) return false;
        AssetAuthority that = (AssetAuthority) o;
        return isRead() == that.isRead() &&
                isWrite() == that.isWrite() &&
                isDelete() == that.isDelete() &&
                Objects.equals(pk, that.pk);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pk, isRead(), isWrite(), isDelete());
    }
}
