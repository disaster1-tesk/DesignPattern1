package hongchengstudy.reflect.v3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Check
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/2 15:28
 * @Version 1.0
 **/
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {

}
