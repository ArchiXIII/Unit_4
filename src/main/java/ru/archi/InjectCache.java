package main.java.ru.archi;

/**
 * Created by Черный on 12.10.2017.
 */
public @interface InjectCache {
    String cacheName = Cache.class.getName();
}
