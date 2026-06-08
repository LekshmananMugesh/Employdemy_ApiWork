package com.example.ApiWork.Repository;

import com.example.ApiWork.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee,Integer> {

}