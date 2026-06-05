package com.example.ApiWork.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String employeeName;

    private String employeeDomain;

    private String employeeAddress;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL
    )
    private List<Gadget> gadgets;

}
