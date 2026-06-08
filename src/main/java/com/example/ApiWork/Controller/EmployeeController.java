package com.example.ApiWork.Controller;



import com.example.ApiWork.DTO.EmployeeDTO;
import com.example.ApiWork.Models.Employee;
import com.example.ApiWork.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Controller
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

    @PatchMapping("/updateParticular/{id}")
    public Employee updateParticularField( @PathVariable int id , @RequestBody EmployeeDTO dto){

        return service.updateParticularUser(id , dto);
    }

}
