package com.example.fiveweekhomework.mapper;

import com.example.fiveweekhomework.entity.Student;

public interface StudentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}