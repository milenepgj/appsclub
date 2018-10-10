package com.appsclub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Permite realizar a persistência dos dados de aplicativos dos pacotes que uma operadora pode oferecer
 */

@Entity
@Table(name = "operatorpackapp")
public class OperatorPackApp implements Serializable {

    private static final long serialVersionUID = -5553233819063777926L;

    @EmbeddedId
    private OperatorPackAppId operatorPackAppId;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("opId")
    private Operator operator;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("appId")
    private Application app;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("packId")
    private PackType pack;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public PackType getPack() {
        return pack;
    }

    public void setPack(PackType pack) {
        this.pack = pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OperatorPackApp that = (OperatorPackApp) o;
        return Objects.equals(app, that.app) &&
                Objects.equals(pack, that.pack) &&
                Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(app, pack, operator);
    }

}