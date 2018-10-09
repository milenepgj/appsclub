package com.appsclub.repository;

import com.appsclub.model.PackApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackAppRepository extends JpaRepository<PackApp, Integer> {

    @Query("SELECT pa FROM Operator p, PackApp pa, Application a, PackType pt " +
            "WHERE p.name = :operator " +
            "and pa.operator.id = p.id " +
            "and pa.app.id = a.id " +
            "and pa.pack.id = pt.id " +
            "and pt.name = :pack")
    public List<PackApp> findByOperatorAndPack(@Param("operator") String operator, @Param("pack") String pack);
}
