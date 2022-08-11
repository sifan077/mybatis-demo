/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/4
 * Time: 20:12
 * Describe: 测试动态sql
 */

import com.shentu.mapper.StudentMapper;
import com.shentu.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDynamic {
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
     * 测试 <if> 标签
     */
    @Test
    public void testIf() {
        SqlSession open = open();
        StudentMapper mapper = open.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("Tom");      //动态查询，设置参数
        student.setPassword("11111");
        List<Student> students = mapper.selectIf(student);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    /**
     * 测试<where>标签
     */
    @Test
    public void testWhere() {
        SqlSession open = open();
        StudentMapper mapper = open.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("Tom");      //动态查询，设置参数
        student.setPassword("11111");
        List<Student> students = mapper.where(student);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    /**
     * 测试<choose>标签
     */
    @Test
    public void testChoose() {
        SqlSession open = open();
        StudentMapper mapper = open.getMapper(StudentMapper.class);
        Student student = new Student();
//        student.setName("Tom");      //动态查询，设置参数
        student.setId(1);
        List<Student> students = mapper.choose(student);
        for (Student s : students) {
            System.out.println(s);
        }
    }


    /**
     * 测试<set>标签
     */
    @Test
    public void testSet() {
        SqlSession open = open();
        StudentMapper mapper = open.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(4);
        student.setName("Kom1");
        student.setPassword("1234567");
        mapper.set(student);
    }

    /**
     * 测试<foreach>标签
     */
    @Test
    public void testForEach() {
        SqlSession open = open();
        StudentMapper mapper = open.getMapper(StudentMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        List<Student> students = mapper.foreach(ids);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * 测试<foreach>标签
     */
    @Test
    public void testForEachInsert() {
        SqlSession open = open();
        StudentMapper mapper = open.getMapper(StudentMapper.class);
        List<Student> list = new ArrayList<>();
        list.add(new Student(null, "Test1", "123456"));
        list.add(new Student(null, "Test2", "123456"));
        list.add(new Student(null, "Test3", "123456"));
        list.add(new Student(null, "Test4", "123456"));
        mapper.foreachInsert(list);
        List<Student> students = mapper.where(new Student());
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
