package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // savedata
    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){

        log.info("####################################### save employee data");
        return ResponseEntity.ok(employeeService.saveData(employee));
    }

    // getdatabyid
    @GetMapping("/getdatabyid/{id}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int id){

        log.info("####################################### get employee data by ID");
        return ResponseEntity.ok(employeeService.getDataById(id));
    }

    // getalldata
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){

        log.info("#################################################### get all employee data");
        return ResponseEntity.ok(employeeService.getAllData());
    }

    // updatedata
    @PutMapping("/updatedatabyid/{id}")
    public ResponseEntity<Employee> updateDataById(@PathVariable int id, @RequestBody Employee employee){

        log.info("################################################# update employee data by ID");
        Employee employee1 = employeeService.getDataById(id).orElseThrow(() -> new RecordNotFoundException("RECORD NOT FOUND"));

        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());

        return ResponseEntity.ok(employeeService.updateData(employee1));
    }

    //deletedatabyid
    @DeleteMapping("/deletedatabyid/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("DATA DELETED");
    }
}
