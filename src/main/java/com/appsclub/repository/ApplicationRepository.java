package com.appsclub.repository;

import com.appsclub.model.Application;
import com.appsclub.model.PackApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query("SELECT a FROM Application a " +
            "WHERE a.country = :country")
    public List<Application> findByCountry(@Param("country") String country);
}
