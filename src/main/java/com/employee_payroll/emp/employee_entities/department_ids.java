package com.employee_payroll.emp.employee_entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class department_ids {
    @Id
    String dept_id;
    String dept_name;
}
