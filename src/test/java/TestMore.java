/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/5
 * Time: 17:28
 * Describe:
 */

import com.shentu.mapper.CustomerMapper;
import com.shentu.mapper.OrdersMapper;
import com.shentu.pojo.Orders;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestMore {
    /**
     * 获取JDBC 操作的SqlSession
     *
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

    /**
     * 测试级联查询
     */
    @Test
    public void testCascade() {
        SqlSession session = open();
        OrdersMapper mapper = session.getMapper(OrdersMapper.class);
        Orders orders = mapper.selectOrdersById(2);
        System.out.println(orders);
        log.debug("orders = {}", orders);

        System.out.println("--------------------------------------");

        //多对多查询
        CustomerMapper mapper1 = session.getMapper(CustomerMapper.class);
        List<Orders> orders1 = mapper1.selectUserOrderById(2);
        System.out.println(orders1);
        log.debug("orders1 = {}", orders1);
    }
}
