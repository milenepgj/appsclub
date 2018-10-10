package com.appsclub.repository;

import com.appsclub.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Permite acessar os dados de aplicativos
 */

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query("SELECT a FROM Application a " +
            "WHERE a.country = :country")
    public List<Application> findByCountry(@Param("country") String country);

    @Query("SELECT a FROM Operator p, OperatorPackApp pa, Application a, PackType pt " +
            "WHERE a.country = :country " +
            "and pa.operator.id = p.id " +
            "and pa.app.id = a.id " +
            "and pa.pack.id = pt.id " +
            "and pt.name = :packname")
    public List<Application> findByCountryAndPackName(@Param("country") String country, @Param("packname") String packname);

    @Query("SELECT a FROM Application a " +
            "WHERE a.name = :name")
    public Optional<Application> findByName(@Param("name") String name);

}
