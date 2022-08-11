package com.shentu.mapper;

import com.shentu.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminMapper {

    /**
     * 增加用户
     * @param admin
     * @return 成功返回1，失败返回0
     */
    @Insert("insert into admin(name,age) values(#{name},#{age})")
    int addAdmin(Admin admin);

    /**
     * 更新用户信息
     * @param admin
     * @return 成功返回1，失败返回0
     */
    @Update("update admin set name=#{name},age=#{age} where id=#{id}")
    int updateAdmin(Admin admin);

    /**
     * 根据删除用户
     * @param id
     * @return 成功返回1，失败返回0
     */
    @Delete("delete from admin where id=#{id}")
    int deleteAdmin(int id);

    /**
     * 根据id查找管理员
     * @param id
     * @return 管理员对象
     */
    @Select("select id,name,age from admin where id=#{id}")
    Admin findAdminById(@Param("id") int id);

    /**
     * 查询所有的管理员
     * @return 管理员对象集合
     */
    @Select("select id,name,age from admin")
    List<Admin> findAllAdmins();

}
