package com.appsclub.repository;

import com.appsclub.model.OperatorPackApp;
import com.appsclub.model.PackApp;
import com.appsclub.model.PackType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Permite acessar os dados de pacotes
 */
@Repository
public interface PackTypeRepository extends JpaRepository<PackType, Integer> {

    @Query("SELECT distinct a FROM PackType a " +
            "WHERE a.name = :name")
    public Optional<PackType> findByName(@Param("name") String name);


    @Query("SELECT distinct pt FROM Operator p, OperatorPackApp pa, Application a, PackType pt, PackApp packapp " +
            "WHERE a.country = :country " +
            "and pa.operator.id = p.id " +
            "and pa.operatorPackAppId.packApp.app.id = a.id " +
            "and pa.operatorPackAppId.packApp.pack.id = pt.id " +
            "and pt.name = :packname " +
            "and packapp.app.id = a.id " +
            "and packapp.pack.id = pt.id ")
    public List<PackType> findByCountryAndPackName(@Param("country") String country, @Param("packname") String packname);
}
