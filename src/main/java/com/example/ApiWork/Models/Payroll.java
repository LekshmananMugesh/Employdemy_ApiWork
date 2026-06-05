package com.example.ApiWork.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer payrollId;
    private Double baseSalary;
    private Double bonus;
    private Double tax;
    private Double netSalary;
    private String salaryMonth;
    private String salarySlip;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
}

