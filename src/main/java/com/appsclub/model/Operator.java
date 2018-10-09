package com.appsclub.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Operator")
@Table(name = "operator")
@EntityListeners(AuditingEntityListener.class)
public class Operator implements Serializable {

    private static final long serialVersionUID = -5753431349185341927L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String country;

    @OneToMany(
            mappedBy = "operator",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PackApp> packs = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
/*
    public List<PackApp> getPacks() {
        return packs;
    }

    public void setPacks(List<PackApp> packs) {
        this.packs = packs;
    }*/
}
