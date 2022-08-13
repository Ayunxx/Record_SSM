package com.ssm.spring_2.dao.impl;

import com.ssm.spring_2.dao.StudentDao;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDaoImpl implements StudentDao {
    @Override
    public void save() {
        System.out.println("保存成功");
    }
}
