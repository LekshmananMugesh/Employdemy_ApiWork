package com.example.ApiWork.Controller;


import com.example.ApiWork.Dto.GadgetDTO;
import com.example.ApiWork.Models.Employee;
import com.example.ApiWork.Models.Gadget;
import com.example.ApiWork.Service.GadgetService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GadgetController {
    private GadgetService service;

    public GadgetController(GadgetService service){
        this.service = service;
    }

    @PostMapping("/employee/{id}/gadget")
    public Gadget addGadget(@PathVariable int id, @RequestBody GadgetDTO dto){

        return service.addGadget(id, dto);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getSpecificEmployee(@PathVariable int id){
        return service.getSpecificEmployee(id);
    }

}