/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/3
 * Time: 23:09
 * Describe: 测试mybatis注解
 */

import com.shentu.mapper.AdminMapper;
import com.shentu.pojo.Admin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

public class TestMybatisAnnotations {

    /**
     * 获取JDBC 操作的SqlSession
     * @return SqlSession
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

    @Test
    public void add() {
        SqlSession open = open();
        AdminMapper mapper = open.getMapper(AdminMapper.class);
        System.out.println(mapper.addAdmin(new Admin(null, "admin", 22)));
    }

    @Test
    public void select() {
        SqlSession open = open();
        AdminMapper mapper = open.getMapper(AdminMapper.class);
        List<Admin> allAdmins = mapper.findAllAdmins();
        for (Admin admin : allAdmins) {
            System.out.println(admin);
        }
    }

    @Test
    public void delete() {
        SqlSession open = open();
        AdminMapper mapper = open.getMapper(AdminMapper.class);
        System.out.println(mapper.deleteAdmin(1));
    }

    @Test
    public void update() {
        SqlSession open = open();
        AdminMapper mapper = open.getMapper(AdminMapper.class);
        System.out.println(mapper.updateAdmin(new Admin(1, "admin", 18)));
    }
}
