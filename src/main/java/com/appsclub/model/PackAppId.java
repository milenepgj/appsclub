package com.appsclub.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PackAppId implements Serializable {

    @Column(name = "app_id")
    private int appId;
    @Column(name = "pack_id")
    private int packId;

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
