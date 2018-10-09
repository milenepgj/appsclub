package com.appsclub.repository;

import com.appsclub.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT p FROM Employee p WHERE p.name = :name and p.id = :id")
    public List<Employee> findByNameAndId(@Param("name") String name, @Param("id") int id);
}
