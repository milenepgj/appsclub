package com.appsclub.repository;

import com.appsclub.model.PackType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Permite acessar os dados de pacotes
 */
@Repository
public interface PackTypeRepository extends JpaRepository<PackType, Integer> {

    @Query("SELECT a FROM PackType a " +
            "WHERE a.name = :name")
    public Optional<PackType> findByName(@Param("name") String name);
}
