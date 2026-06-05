package com.example.ApiWork.Service;

import com.example.ApiWork.DTO.PayrollDTO;
import com.example.ApiWork.Models.Employee;
import com.example.ApiWork.Models.Payroll;
import com.example.ApiWork.Repository.EmployeeRepository;
import com.example.ApiWork.Repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    private PayrollRepository payrollRepo;
    private EmployeeRepository empRepo;

    public PayrollService(PayrollRepository payrollRepo , EmployeeRepository empRepo){
        this.payrollRepo = payrollRepo;
        this.empRepo = empRepo;
    }

    public Payroll addPayroll(int empId, PayrollDTO payDto){

        Employee emp = empRepo.findById(empId).orElse(null);

        if(emp == null){
            return null;
        }
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(payDto.getBaseSalary());
        payroll.setBonus(payDto.getBonus());
        payroll.setTax(payDto.getTax());
        Double netSalary = payDto.getBaseSalary() + payDto.getBonus() - payDto.getTax();
        payroll.setNetSalary(netSalary);
        payroll.setSalaryMonth(payDto.getSalaryMonth());
        payroll.setSalarySlip(payDto.getSalarySlip());
        payroll.setEmployee(emp);
        return payrollRepo.save(payroll);
    }

    public List<Payroll> getEmployeePayroll(int id ){

        Employee emp = empRepo.findById(id).orElse(null);

        if(emp == null){
            return null;
        }
        return emp.getPayroll();
    }

    public Payroll getSalarySlip(int payrollId){

        Payroll pay = payrollRepo.findById(payrollId).orElse(null);

        if(pay == null){
            return null;
        }
        return pay;
    }
    public Payroll updatePayroll(int payrollId, PayrollDTO dto){


        Payroll payroll = payrollRepo.findById(payrollId).orElse(null);

        if(payroll == null){
            return null;
        }
        payroll.setBaseSalary(dto.getBaseSalary());
        payroll.setBonus(dto.getBonus());
        payroll.setTax(dto.getTax());
        Double net = dto.getBaseSalary() + dto.getBonus() - dto.getTax();
        payroll.setNetSalary(net);
        payroll.setSalaryMonth(dto.getSalaryMonth());
        payroll.setSalarySlip(dto.getSalarySlip());
        return payrollRepo.save(payroll);
    }
    public Employee getEmployeeProfile(int employeeId){

        Employee emp = empRepo.findById(employeeId).orElse(null);
        if(emp == null){
            return null;
        }
        return emp;
    }
}
