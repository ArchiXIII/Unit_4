package main.java.ru.archi;

import java.lang.reflect.Field;

/**
 * Created by Черный on 13.10.2017.
 */
public class ClassInjector {
    public static void putCache(Cache cache){
        Class cacheClass = cache.getClass();

        Field cacheName = null;
        try {
            cacheName = cacheClass.getDeclaredField("firstList");
            cacheName.setAccessible(true);
            cacheName.set(cacheClass, cacheClass.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
