package com.employee_payroll.emp.controller;

import com.employee_payroll.emp.config_programs.Response;
import com.employee_payroll.emp.DTO.RegistrationDTO;
import com.employee_payroll.emp.employee_entities.EmployeeModel;
import com.employee_payroll.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/empAdmin")
public class EmpController {

    @Autowired
    IEmpService empServices;

    @Autowired
    Response response;

    @PostMapping("/addUser")
    public ResponseEntity<Response> addUser(@RequestBody RegistrationDTO empRegistration){
        empServices.addUser(empRegistration);
        response.setMessage("Employee Added Successfully");
        response.setObject(empRegistration);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable int id, @RequestBody RegistrationDTO update){
        empServices.update(id,update);
        response.setMessage("Data Updated");
        response.setObject(update);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Response> deleteUser (@RequestParam int id){
        EmployeeModel deletedEmp = empServices.deleteUser(id);
        response.setMessage("User Deleted Successfully");
        response.setObject(deletedEmp);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Response> searchUser (@RequestParam String employeeName){
        RegistrationDTO searchResult = empServices.searchUser(employeeName);
        response.setMessage("User Found");
        response.setObject(searchResult);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
