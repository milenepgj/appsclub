package com.appsclub.repository;

import com.appsclub.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Permite acessar os dados de operadoras
 */
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

    @Query("SELECT a FROM Operator a " +
            "WHERE a.name = :name")
    public Optional<Operator> findByName(@Param("name") String name);
}
