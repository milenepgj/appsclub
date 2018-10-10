package com.appsclub.repository;

import com.appsclub.model.OperatorPackApp;
import com.appsclub.model.PackType;
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
public interface OperatorPackAppRepository extends JpaRepository<OperatorPackApp, Integer> {

    @Query("SELECT pa FROM Operator p, OperatorPackApp pa, Application a, PackType pt " +
            "WHERE p.name = :operator " +
            "and pa.operator.id = p.id " +
            "and pa.operatorPackAppId.packApp.app.id = a.id " +
            "and pa.operatorPackAppId.packApp.pack.id = pt.id " +
            "and pt.name = :pack")
    public List<OperatorPackApp> findByOperatorAndPack(@Param("operator") String operator, @Param("pack") String pack);

    @Query("SELECT pa FROM Operator p, OperatorPackApp pa, Application a, PackType pt " +
            "WHERE pa.operator.id = p.id " +
            "and pa.operatorPackAppId.packApp.app.id = a.id " +
            "and pa.operatorPackAppId.packApp.pack.id = pt.id " +
            "and a.country = :country")
    public List<OperatorPackApp> findByCountry(@Param("country") String country);


}
