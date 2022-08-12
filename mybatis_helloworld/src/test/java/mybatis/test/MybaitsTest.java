package mybatis.test;

import com.ssm.mybatis_1.mapper.UserMapper;
import com.ssm.mybatis_1.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybaitsTest {


    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取sql的会话对象sqlSession (不会自动提交事务)
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取sql的会话对象sqlSession (会自动提交事务)
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取Mapper代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的实现方法，实现添加
        int res = userMapper.insertUser();
        System.out.println("结果"+res);
        //提交事务
        //sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }
}
