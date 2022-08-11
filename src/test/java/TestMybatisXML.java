/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/3
 * Time: 17:56
 * Describe: 测试Mybatis XML
 */

import com.shentu.mapper.UserMapper;
import com.shentu.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatisXML {

    /**
     * 获取JDBC 操作的SqlSession
     */
    private static SqlSession open() {
        // 1、创建一个SqlSessionFactory的 建造者 ，用于创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 2、使用builder构建一个sqlSessionFactory，此处我们基于一个xml配置文件
        SqlSessionFactory sqlSessionFactory = builder.build(Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("mybatis-config.xml"));
        // 3、通过sqlSessionFactory获取另一个session，此处使用【工厂设计模式】
        //4. 设置自动提交  sqlSessionFactory.openSession(true);
        return sqlSessionFactory.openSession(true);
    }

    /**
     * 测试是否能启动
     */
    @Test
    public void test() {
        System.out.println("hello world");
    }

    /**
     * 测试Insert操作
     */
    @Test
    public void testInsert() {
        // 1、获取SqlSession
        SqlSession session = open();
        // 2、获取Mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insert(new User(null, "张三", "123456"));
        session.commit();
        session.close();
    }

    /**
     * 查询全部
     */
    @Test
    public void testSelect() {
        // 1、获取SqlSession
        SqlSession session = open();
        // 2、获取Mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 模糊查询测试
     */
    @Test
    public void testSelectByName() {
        // 1、获取SqlSession
        SqlSession session = open();
        // 2、获取Mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectByName("张");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 使用map查询
     */
    @Test
    public void testMapSelect() {
        // 1、获取SqlSession
        SqlSession session = open();
        // 2、获取Mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "思凡");
        List<User> users = mapper.selectByParams(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 别名查询
     */
    @Test
    public void testAlias() {
        // 1、获取SqlSession
        SqlSession session = open();
        // 2、获取Mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.select();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
