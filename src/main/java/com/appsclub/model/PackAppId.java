package com.appsclub.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Identificador da classe de persistência dos aplicativos relacionados aos pacotes que uma operadora pode oferecer
 */

@Embeddable
public class PackAppId implements Serializable {

    @Column(name = "app_id")
    private int appId;

    @Column(name = "pack_id")
    private int packId;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PackAppId that = (PackAppId) o;
        return Objects.equals(appId, that.appId) &&
                Objects.equals(packId, that.packId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, packId);
    }

}
