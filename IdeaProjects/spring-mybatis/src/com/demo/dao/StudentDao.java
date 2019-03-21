package com.demo.dao;

import com.demo.beans.Student;

import java.util.List;

/**
 * @Authou YXY
 * @Date 2018/10/31 18:37
 */
public interface StudentDao {
    int insertStudent(Student student);
    int updateStduent(Student student);
    int deleteStudent(Integer id);

    Student selectStudentById(Integer id);
    List<Student> selectStudent();
}
