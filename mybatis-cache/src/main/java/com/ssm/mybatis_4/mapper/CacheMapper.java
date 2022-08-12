package com.ssm.mybatis_4.mapper;

import com.ssm.mybatis_4.entity.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {


    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId")Integer empId);

    /**
     * 添加员工
     * @param emp
     */
    void insertEmp (Emp emp);
}
