package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    // savedata
    public Employee saveData(Employee employee){
        return employeeRepo.save(employee);
    }

    // getdatabyid
    public Optional<Employee> getDataById(int id){
        return employeeRepo.findById(id);
    }

    // getalldata
    public List<Employee> getAllData(){
        return employeeRepo.findAll();
    }

    // updatedata
    public Employee updateData(Employee employee){
        return employeeRepo.save(employee);
    }

    //deletedatabyid
    public void deleteById(int id){
        employeeRepo.deleteById(id);
    }
}
