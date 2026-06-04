package com.example.ApiWork.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="gadgets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gadget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String gadgetName;

    private String gadgetType;

    private String gadgetBrand;

    @ManyToOne
    @JoinColumn(name="employee_id")
    @JsonBackReference
    private Employee employee;

}