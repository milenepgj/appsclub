package com.appsclub.repository;

import com.appsclub.model.OperatorPackApp;
import com.appsclub.model.PackApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Permite acessar os dados de pacotes de aplicativos
 */

@Repository
public interface PackAppRepository extends JpaRepository<PackApp, Integer> {

    @Query("SELECT pa FROM PackApp pa, Application a, PackType pt " +
            "WHERE pa.app.id = a.id " +
            "and pa.pack.id = pt.id " +
            "and pt.name = :pack")
    public List<PackApp> findByName(@Param("pack") String pack);

    @Query("SELECT pa FROM PackApp pa, Application a, PackType pt " +
            "WHERE pa.app.id = a.id " +
            "and pa.pack.id = pt.id " +
            "and a.country = :country")
    public List<PackApp> findByCountry(@Param("country") String country);


}
