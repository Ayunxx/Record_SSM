package com.test;

import com.ssm.mybatis_4.entity.Emp;
import com.ssm.mybatis_4.mapper.CacheMapper;
import com.ssm.mybatis_4.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CacheMapperTest {
    /**
     * Mybatis的一级缓存：
     * Mybatis的一级缓存是SqlSession级别的 即通过同一个SqlSession查询的数据会被缓存
     * 再次使用同一个SqlSession查询同一条数据时会从缓存中读取
     * 使一级缓存失效的四种情况：
     *  1） 不同的SqlSession对应不同的一级缓存
     *  2） 同一个SqlSession但是查询条件不同
     *  3） 同一个SqlSession两次查询期间执行了任何一次增删改的操作
     *  4） 同一个SqlSession两次查询期间手动清空了缓存
     * */

    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        mapper.insertEmp(new Emp(null,"小红",22,"女"));
        sqlSession.clearCache();//手动清空
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp3);

    }
}
