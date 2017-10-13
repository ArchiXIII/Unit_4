package main.java.ru.archi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Черный on 12.10.2017.
 */
public @interface CacheDeclaration {
    String name = Cache.class.getName();
}
