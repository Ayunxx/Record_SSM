package com.ssm.mybatis_2.mapper;

import com.ssm.mybatis_2.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Objects;

/*
*   mybatis获取值的两种方式  '${}' #{}
*   ${}要注意引号问题   ${}本质是拼接sql  #{}本质是占位符
*
*   多个参数时mybatis会将多个参数放在map 集合中 以键值对的方式存储
*   以a> arg0,arg1....为键 参数为值
*   以p> param1,param2....为键 参数为值
* */

public interface UserMapper {

    User getUserByUsername(String username);

    User checkLogin(String username , String password);

    User checkLoginByMap(Map<String, Object> map);

    void insertUser(User user);

    /**
     * 验证登录 使用 @Param注解
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
