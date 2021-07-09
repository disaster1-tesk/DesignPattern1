package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
        能够做注解中的属性的类型有：byte  short  int  long  double  float  boolean  char  String  enum
        其中如果注解中的属性有且只有名字为value且这个注解属性，那么在注解的使用中，可以省略value属性名进行赋值
 */
//这个元注解所注解的注解能修饰类、属性、方法
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
//这个元注解所注解的注解能被反射机制所获取
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value();
    int age() default 20;
}
