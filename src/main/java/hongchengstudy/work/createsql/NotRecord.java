package hongchengstudy.work.createsql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName NotRecord
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/2 17:46
 * @Version 1.0
 **/
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRecord {

}
