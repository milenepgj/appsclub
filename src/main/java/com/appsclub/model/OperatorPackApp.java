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

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Application getApp() {
        return operatorPackAppId.getPackApp().getApp();
    }

    public PackType getPack() {
        return operatorPackAppId.getPackApp().getPack();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OperatorPackApp that = (OperatorPackApp) o;
        return Objects.equals(operatorPackAppId.getPackApp().getApp().getId(), that.operatorPackAppId.getPackApp().getApp().getId()) &&
                Objects.equals(operatorPackAppId.getPackApp().getPack().getId(), that.operatorPackAppId.getPackApp().getPack().getId()) &&
                Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatorPackAppId.getPackApp().getApp().getId(), operatorPackAppId.getPackApp().getPack().getId(), operator);
    }

}
