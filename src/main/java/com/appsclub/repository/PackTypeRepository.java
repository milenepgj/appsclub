package com.appsclub.repository;

import com.appsclub.model.PackType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackTypeRepository extends JpaRepository<PackType, Integer> {

}
