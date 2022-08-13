package com.ssm.spring_2.service.impl;

import com.ssm.spring_2.dao.StudentDao;
import com.ssm.spring_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public void saveStudent() {
        studentDao.save();
    }
}
