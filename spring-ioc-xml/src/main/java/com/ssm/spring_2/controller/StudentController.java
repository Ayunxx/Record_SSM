package com.ssm.spring_2.controller;

import com.ssm.spring_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void saveStudent(){
        studentService.saveStudent();
    }
}
