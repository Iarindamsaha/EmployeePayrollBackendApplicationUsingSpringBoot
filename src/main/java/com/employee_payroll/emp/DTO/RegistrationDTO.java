package com.employee_payroll.emp.DTO;

import com.employee_payroll.emp.employee_entities.department_ids;
import lombok.Data;

import java.util.List;

@Data
public class RegistrationDTO {
    String empName;
    String profilePic;
    String gender;
    long salary;
    String startDate;
    String notes;
    List<department_ids> department;
}
