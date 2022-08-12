package com.test;

import com.ssm.mybatis_2.entity.User;
import com.ssm.mybatis_2.mapper.UserMapper;
import com.ssm.mybatis_2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {


    @Test
    public void testgetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("123");
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("123","123");
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","123");
        map.put("password","123");
        User user = mapper.checkLoginByMap(map);
        sqlSession.close();
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,33,"toor","123456","女","123123@qq.com");
        mapper.insertUser(user);
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void checkLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("123","123");
        sqlSession.close();
        System.out.println(user);
    }
}
