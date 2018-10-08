package com.appsclub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "packapp")
public class PackApp  implements Serializable {

    private static final long serialVersionUID = -5553233819063777926L;

    @EmbeddedId
    private PackAppId packAppId;

    @OneToOne(fetch = FetchType.LAZY)
    private Operator operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("appId")
    private Application app;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("packId")
    private PackType pack;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PackApp that = (PackApp) o;
        return Objects.equals(app, that.app) &&
                Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(app, pack);
    }

}
