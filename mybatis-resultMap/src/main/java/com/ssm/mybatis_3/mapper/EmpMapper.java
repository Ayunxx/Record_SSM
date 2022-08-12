package com.ssm.mybatis_3.mapper;

import com.ssm.mybatis_3.entity.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId")Integer empId);
}
