package com.employee_payroll.emp.user_exception;

import com.employee_payroll.emp.config_programs.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
@ResponseBody
public class GlobalException extends Exception {

    @Autowired
    Response  response;

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<Response> exceptionMessage(UserException exception){

        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response,exception.status);

    }


}
