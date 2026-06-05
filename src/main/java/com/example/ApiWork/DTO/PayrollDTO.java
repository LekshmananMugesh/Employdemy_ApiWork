package com.example.ApiWork.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayrollDTO {

    private Double baseSalary;
    private Double bonus;
    private Double tax;
    private String salaryMonth;
    private String salarySlip;
}
