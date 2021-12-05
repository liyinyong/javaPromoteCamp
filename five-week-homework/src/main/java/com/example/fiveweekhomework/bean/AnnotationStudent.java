package com.example.fiveweekhomework.bean;

import org.springframework.stereotype.Component;

@Component
public class AnnotationStudent extends Student{
    public AnnotationStudent() {
        this.setId(2);
        this.setName("annotationStudent");
    }
}
