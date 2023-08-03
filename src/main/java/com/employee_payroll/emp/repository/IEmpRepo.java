package com.employee_payroll.emp.repository;


import com.employee_payroll.emp.employee_entities.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpRepo extends JpaRepository<EmployeeModel,Integer> {

    EmployeeModel findByempName(String empName);


}
