package com.employee_payroll.emp.employee_entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userID;

    String empName;
    String profilePic;
    String gender;
    long salary;
    String startDate;
    String notes;
    @ManyToMany
    List<department_ids> department;

}

//multipart file
