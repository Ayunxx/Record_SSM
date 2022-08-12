package com.test;

import com.ssm.mybatis_3.entity.Emp;
import com.ssm.mybatis_3.mapper.EmpMapper;
import com.ssm.mybatis_3.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapTest {

    /*
    *   当数据库字段与实体类名不相符时，有三种解决方案
    *       1、在sql语句中设置别名
    *       2、在mybatis 配置文件中 配置全局settings
    *       3、使用resultMap 进行字段映射
    * */

    @Test
    public void testgetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);

    }
}
