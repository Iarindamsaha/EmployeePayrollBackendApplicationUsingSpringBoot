package com.employee_payroll.emp.service;

import com.employee_payroll.emp.DTO.RegistrationDTO;
import com.employee_payroll.emp.employee_entities.EmployeeModel;
import com.employee_payroll.emp.repository.IEmpRepo;
import com.employee_payroll.emp.user_exception.UserException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class EmpServices implements IEmpService {


    @Autowired
    IEmpRepo empRepo;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public void addUser(RegistrationDTO register) {

        EmployeeModel emp = modelMapper.map(register,EmployeeModel.class);
        empRepo.save(emp);

    }

    @Override
    public void update(int id,RegistrationDTO update) {

        EmployeeModel empUpdate = empRepo.getReferenceById(id);

        empUpdate.setEmpName(update.getEmpName());
        empUpdate.setProfilePic(update.getProfilePic());
        empUpdate.setGender(update.getGender());
        empUpdate.setSalary(update.getSalary());
        empUpdate.setStartDate(update.getStartDate());
        empUpdate.setNotes(update.getNotes());

        empRepo.save(empUpdate);
    }

    @Override
    public EmployeeModel deleteUser(int id) {

        EmployeeModel employeePOJO = empRepo.findById(id).orElse(null);
        if(employeePOJO == null){
            throw new UserException("User Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        empRepo.deleteById(id);
        return employeePOJO;
    }

    @Override
    public RegistrationDTO searchUser(String empName) {

        EmployeeModel searchResult = empRepo.findByempName(empName);

        if(searchResult == null){
            throw new UserException("User Not Available",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return modelMapper.map(searchResult,RegistrationDTO.class);
    }

}
