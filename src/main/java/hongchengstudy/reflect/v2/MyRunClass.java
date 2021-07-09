package hongchengstudy.reflect.v2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/*
反编译之后的代码块：
public interface com.Annotation.MyAnnotation extends java.lang.annotation.Annotation {
  public abstract java.lang.String[] value();
  public abstract int age();
}
 */
public @interface MyRunClass {
    String className();
    String methodName();
}
