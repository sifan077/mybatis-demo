package com.shentu.mapper;

import com.shentu.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询学生信息 if
     * @return List<Student>
     */
    List<Student> selectIf(Student student);

    /**
     * 查询学生信息，where
     * @param student
     * @return List<Student>
     */
    List<Student> where(Student student);

    /**
     * 查询学生信息，trim
     * @param student
     * @return List<Student>
     */
    List<Student> trim(Student student);

    /**
     * 查询学生信息，choose
     * @param student
     * @return List<Student>
     */
    List<Student> choose(Student student);

    /**
     * 更新学生信息，set
     * @param student
     * @return List<Student>
     */
    int set(Student student);

    /**
     * 根据参数列表查询学生信息，foreach
     * @param ids
     * @return List<Student>
     */
    List<Student> foreach(List<Integer> ids);

    /**
     * 批量插入学生信息，foreach
     * @param students
     * @return int
     */
    int foreachInsert(List<Student> students);
}
