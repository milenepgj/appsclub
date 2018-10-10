package com.appsclub.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Identificador da classe de persistência dos aplicativos relacionados aos pacotes que uma operadora pode oferecer
 */

@Embeddable
public class OperatorPackAppId implements Serializable {

    @Column(name = "app_id")
    private int appId;

    @Column(name = "pack_id")
    private int packId;

    @Column(name = "operator_id")
    private int opId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OperatorPackAppId that = (OperatorPackAppId) o;
        return Objects.equals(appId, that.appId) &&
                Objects.equals(packId, that.packId) &&
                Objects.equals(opId, that.opId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, packId, opId);
    }

}
