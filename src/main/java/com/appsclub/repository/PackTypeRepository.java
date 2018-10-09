package com.appsclub.repository;

import com.appsclub.model.Employee;
import com.appsclub.model.PackApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackTypeRepository extends JpaRepository<Employee, Integer> {

}
