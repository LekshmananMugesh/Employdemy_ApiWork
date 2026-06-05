package com.example.ApiWork.Service;

import com.example.ApiWork.DTO.GadgetDTO;
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

        Employee emp = employeeRepo.findById(employeeId).orElse(null);

        if(emp == null){
            return null;
        }

        Gadget gadget = new Gadget();
        int nextNumber = emp.getGadgets().size() + 1;
        gadget.setGadgetNumber(nextNumber);
        gadget.setGadgetName(dto.getGadgetName());
        gadget.setGadgetType(dto.getGadgetType());
        gadget.setGadgetBrand(dto.getGadgetBrand());
        gadget.setEmployee(emp);
        return gadgetRepo.save(gadget);
    }

    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getSpecificEmployee(int id) {

        Employee emp = employeeRepo.findById(id).orElse(null);

        if(emp==null){
            return null;
        }

        return emp;
    }
    public String deleteSpecificGadget(int empId , int gdId){

        Employee emp = employeeRepo.findById(empId).orElse(null);

        if(emp == null){
            return "Employee Not found";
        }

        Gadget gadget = gadgetRepo.findById(gdId).orElse(null);

        if(gadget == null){
            return "Gadget not found";
        }

        if(gadget.getEmployee().getEmployeeId() != empId){
            return "Gadget not belongs to employee";
        }

        gadgetRepo.delete(gadget);
        return "Gadget Deleted";
    }
}