package com.example.ApiWork.Controller;



import com.example.ApiWork.Models.Employee;
import com.example.ApiWork.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(
            EmployeeService service){

        this.service = service;
    }

    @GetMapping("/get")
    public List<Employee> getAllUser(){

        return service.getAllUser();
    }

    @GetMapping("/get/{id}")
    public Employee getUserById(
            @PathVariable int id){

        return service.getUserById(id);
    }

    @PostMapping("/add")
    public Employee addUser(
            @RequestBody Employee emp){

        return service.addUser(emp);
    }

    @PutMapping("/update/{id}")
    public Employee updateUser(
            @PathVariable int id,
            @RequestBody Employee emp){

        return service.updateUser(id, emp);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(
            @PathVariable int id){

        return service.deleteUser(id);
    }

}
