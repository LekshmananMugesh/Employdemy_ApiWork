package com.example.ApiWork.Service;


import com.example.ApiWork.Models.Employee;
import com.example.ApiWork.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public List<Employee> getAllUser(){
        return repository.findAll();
    }

    public Employee getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public Employee addUser(Employee emp){
        return repository.save(emp);
    }

    public Employee updateUser(int id, Employee emp){

        if(repository.existsById(id)){
            emp.setEmployeeId(id);
            return repository.save(emp);
        }
        return null;
    }

    public String deleteUser(int id){

        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Employee Deleted";
        }

        return "Employee Not Found";
    }

}