package com.javarush.task.task38.task3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value= RetentionPolicy.RUNTIME)
public @interface Author {
    //напиши свой код
    String value() default "";
    Position position() default Position.OTHER;
}
