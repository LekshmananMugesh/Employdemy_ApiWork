package com.example.ApiWork.Service;


import com.example.ApiWork.Dto.GadgetDTO;
import com.example.ApiWork.Models.Employee;
import com.example.ApiWork.Models.Gadget;
import com.example.ApiWork.Repository.EmployeeRepository;
import com.example.ApiWork.Repository.GadgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GadgetService {

    private EmployeeRepository employeeRepo;

    private GadgetRepository gadgetRepo;

    public GadgetService(EmployeeRepository employeeRepo, GadgetRepository gadgetRepo){
        this.employeeRepo = employeeRepo;
        this.gadgetRepo = gadgetRepo;
    }

    public Gadget addGadget(int employeeId, GadgetDTO dto){

        Employee emp = employeeRepo.findById(employeeId)
                        .orElse(null);
        if(emp==null){
            return null;
        }

        Gadget gadget = new Gadget();
        gadget.setGadgetName(dto.getGadgetName());
        gadget.setGadgetType(dto.getGadgetType());
        gadget.setGadgetBrand(dto.getGadgetBrand());
        gadget.setEmployee(emp);
        return gadgetRepo.save(gadget);
    }

    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

}