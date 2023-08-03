package com.employee_payroll.emp.service;

import com.employee_payroll.emp.DTO.RegistrationDTO;
import com.employee_payroll.emp.employee_entities.EmployeeModel;

public interface IEmpService {

    void addUser(RegistrationDTO register);

    void update(int id, RegistrationDTO update);

    EmployeeModel deleteUser(int id);

    RegistrationDTO searchUser(String empName);


}
