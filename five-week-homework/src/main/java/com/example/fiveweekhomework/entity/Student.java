package com.example.fiveweekhomework.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Long id;

    /**
     * 学员名称
     */
    private String name;

    private static final long serialVersionUID = 1L;
}