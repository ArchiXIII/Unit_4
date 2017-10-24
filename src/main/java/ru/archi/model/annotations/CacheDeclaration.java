package main.java.ru.archi.model.annotations;

import java.lang.annotation.*;

/**
 * Created by Черный on 12.10.2017.
 */
@Target(value=ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface CacheDeclaration {
    String cacheName();
}
