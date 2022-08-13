package com.ssm.spring_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer sid;

    private String sname;

    private Integer age;

    private String gender;
}
