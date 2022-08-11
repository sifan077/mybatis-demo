/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/3
 * Time: 17:28
 * Describe: 用户类mapper
 */

package com.shentu.mapper;

import com.shentu.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> selectAll();


    /**
     * 根据id查询用户
     * @param id
     * @return User
     */
    User selectById(int id);

    /**
     * 插入用户
     * @param user
     * @return int
     */
    int insert(User user);

    /**
     * 更新用户
     * @param user
     * @return int
     */
    int update(User user);

    /**
     * 删除用户
     * @param id
     * @return int
     */
    int deleteById(int id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<User> selectByName(String name);

    /**
     * 根据一些参数查询
     * @param map
     * @return
     */
    List<User> selectByParams(Map<String,String> map);

    /**
     * 定义别名查询
     * @return List<User>
     */
    List<User> select();


    /*
     如果数据库字段和实体的字段是一一对应，那么MyBatis会【自动映射】，
     但是如果不一致，比如一个叫user一个叫username，那么就需要我们手动的建立一一映射的关系了。

     解决方案：
           方法一：为列名指定别名 , 别名和java实体类的属性名一致 .
           <select id="selectUserById" resultType="User">
             select id , username as name ,password from user where id = #{id}
            </select>
            方法二：使用结果集映射->ResultMap 【推荐】
            <resultMap id="UserMap" type="User">
                     <!-- id为主键 -->
                  <id column="id" property="id"/>
                     <!-- column是数据库表的列名 , property是对应实体类的属性名 -->
                 <result column="username" property="name"/>
                 <result column="password" property="password"/>
            </resultMap>

           <select id="selectUserById" resultMap="UserMap">
             select id , username , password from user where id = #{id}
           </select>
     */
}
