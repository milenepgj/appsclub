package com.appsclub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Identificador da classe de persistência dos aplicativos relacionados aos pacotes que uma operadora pode oferecer
 */

@Embeddable
public class OperatorPackAppId implements Serializable {

/*    @Column(name = "app_id")
    private int appId;

    @Column(name = "pack_id")
    private int packId;*/

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private PackApp packApp;

    @Column(name = "operator_id")
    private int opId;

    public PackApp getPackApp() {
        return packApp;
    }

    public void setPackApp(PackApp packApp) {
        this.packApp = packApp;
    }

    public int getOpId() {
        return opId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OperatorPackAppId that = (OperatorPackAppId) o;
        return Objects.equals(packApp.getApp().getId(), that.packApp.getApp().getId()) &&
                Objects.equals(packApp.getPack().getId(), that.packApp.getPack().getId()) &&
                Objects.equals(opId, that.opId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packApp.getApp().getId(), packApp.getPack().getId(), opId);
    }

}
