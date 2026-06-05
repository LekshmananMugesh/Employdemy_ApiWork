package com.example.ApiWork.Repository;

import com.example.ApiWork.Models.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll , Integer> {
}
