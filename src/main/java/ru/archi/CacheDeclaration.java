package main.java.ru.archi;

import java.lang.annotation.*;

/**
 * Created by Черный on 12.10.2017.
 */
@Target(value=ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface CacheDeclaration {
    String name() default "";
}
