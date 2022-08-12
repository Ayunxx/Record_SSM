package com.ssm.mybatis_2.mapper;


import com.ssm.mybatis_2.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户总数
     * @return
     */
    Integer gerCount();

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */

    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     * 若查询数据有多条时，并且要将每条数据转换为map集合
     * 此时有两种解决方案
     * 1、将mapper接口方法的返回值设置为泛型是map的list集合
     * List<Map<String,Object>> getUserAllToMap();
     * 2、可以通过每条数据转换的map集合放在一个大的map集合中，但是必须通过@Mapkey注解 将某个字段的值作为键
     * @Mapkey("id")
     * Map<String,Object> getUserAllToMap();
     * @return
     */

    List<Map<String,Object>> getUserAllToMap();

}
