package com.example.ApiWork.Controller;

import com.example.ApiWork.DTO.PayrollDTO;
import com.example.ApiWork.Models.Employee;
import com.example.ApiWork.Models.Payroll;
import com.example.ApiWork.Service.PayrollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PayrollController {

    private PayrollService payService;

    public PayrollController(PayrollService payservice){
        this.payService = payservice;
    }
    //abcd

    @PostMapping("/add/{id}/payroll")
    public Payroll addPayroll(@PathVariable int id , @RequestBody PayrollDTO dto){
        return payService.addPayroll(id , dto);
    }

    @GetMapping("/employees/{id}/payroll")
    public List<Payroll> getEmployeePayroll(@PathVariable int id){
        return payService.getEmployeePayroll(id);
    }

    @GetMapping("/payroll/{payrollId}/slip")
    public Payroll getSalarySlip(@PathVariable int payrollId){
        return payService.getSalarySlip(payrollId);
    }

    @PutMapping("/payroll/{payrollId}")
    public Payroll updatePayroll(@PathVariable int payrollId, @RequestBody PayrollDTO dto){
        return payService.updatePayroll(payrollId, dto);
    }

    @GetMapping("/employees/{id}/profile")
    public Employee getEmployeeProfile(@PathVariable int id){
        return payService.getEmployeeProfile(id);
    }

}
