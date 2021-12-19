package com.example.seventhweekhomework.dynamic;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicChooseSource {
    String name() default "";
}
