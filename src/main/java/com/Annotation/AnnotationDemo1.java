package com.Annotation;
/*
注解：注解也是类，在JDK中定义了一些注解，注解一般只作用在编译阶段！我们常见的注解有
    1:Override
    2:Deprecated
    这两种注解是我们需要掌握的，注解可以放在代码的任何位置，注解同时也可以注解注解，那么，那些注解“注解”的注解我们称为“元注解”
    常见的元注解有：
        @Target(ElementType.METHOD)  这个注解表示所注解的方法或者属性所放的位置
        @Retention(RetentionPolicy.SOURCE)  这个注解表示这个注解这个注解最后生成的位置，也就是这个注解类的所在位置

 */
public class AnnotationDemo1 {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("com.Annotation.Test");
        if (aClass.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = (MyAnnotation) aClass.getAnnotation(MyAnnotation.class);
            if (annotation.age()>20){
                System.out.println(annotation.age());
                System.out.println(annotation.value());
            }else{
                throw new HasAgeException("被@MyAnnotation所注解的类，注解中的age属性必须赋值超过20岁");
            }
        }
    }
}

@MyAnnotation(value = "测试", age = 3)
class Test {
    @MyAnnotation(value = "测试", age = 23)
    public void dosome() {

    }
}
