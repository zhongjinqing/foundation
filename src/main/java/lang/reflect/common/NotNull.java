package main.java.lang.reflect.common;

import java.lang.annotation.*;

/**
 * @author zjq
 * @date 2020/3/26 13:56
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NotNull {
    String value() default "";
}
