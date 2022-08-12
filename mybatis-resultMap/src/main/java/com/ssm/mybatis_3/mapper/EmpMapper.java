package com.ssm.mybatis_3.mapper;

import com.ssm.mybatis_3.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId")Integer empId);

    /**
     * 获取员工以及所对应的部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 通过分步查询 查询员工以及所对应的部门信息 第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 分步查询第二步
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
