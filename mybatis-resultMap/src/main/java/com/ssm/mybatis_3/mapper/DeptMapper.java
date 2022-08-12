package com.ssm.mybatis_3.mapper;

import com.ssm.mybatis_3.entity.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分步查询 查询员工以及所对应的部门信息 第二步
     * @return
     */
    Dept getEmpAndDeptByStepTow(@Param("deptId") Integer deptId);

    /**
     * 查询部门信息以及部门中员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);


    /**
     * 分步查询 第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
