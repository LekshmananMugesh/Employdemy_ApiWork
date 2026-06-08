package com.example.ApiWork.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {

    private String employeeName;

    private String employeeDomain;

    private String employeeAddress;

}