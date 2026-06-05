package com.example.ApiWork.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gadget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer gadgetNumber;
    private String gadgetName;
    private String gadgetType;
    private String gadgetBrand;

    @ManyToOne
    @JoinColumn(name="employee_id")
    @JsonIgnore
    private Employee employee;
}