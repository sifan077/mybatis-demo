/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/3
 * Time: 17:43
 * Describe: mybatis 最基本的增删改查
 */

package com.shentu;
import com.shentu.mapper.UserMapper;
import com.shentu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        String resources = "mybatis-config.xml";
        //2.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream(resources);
        //3.获取SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        //4.获取SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession(true);
        //5.获取dao代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //6.执行方法
        List<User> users = mapper.selectAll();
        log.debug("users={}",users);
        for (User user : users) {
            System.out.println(user);
        }
        User user = mapper.selectById(2);
        log.debug("user={}",user);
        System.out.println(user);
        //7.释放资源
        sqlSession.close();
    }
}
