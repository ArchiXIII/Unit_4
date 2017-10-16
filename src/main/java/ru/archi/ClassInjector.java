package main.java.ru.archi;

import java.lang.reflect.Field;

/**
 * Created by Черный on 13.10.2017.
 */
public class ClassInjector {
    public static void putCache(Cache cache){
        Class cacheClass = cache.getClass();


        try {
            System.out.println(cacheClass.getAnnotation(CacheDeclaration.class));
        } catch (Exception e) {
            e.printStackTrace();
        }



        Field cacheNameField = null;
        String cacheName;
        try {
            cacheNameField = cacheClass.getDeclaredField("cacheName");
            cacheNameField.setAccessible(true);

            cacheName = (String) cacheNameField.get(cache);
            System.out.println(cacheName);

            cacheNameField.set(cache, "archi");

            cacheName = (String) cacheNameField.get(cache);
            System.out.println(cacheName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
