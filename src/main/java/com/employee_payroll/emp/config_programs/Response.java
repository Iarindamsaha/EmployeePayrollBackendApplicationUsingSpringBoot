package com.employee_payroll.emp.config_programs;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Response {
    String message;
    Object object;
}
