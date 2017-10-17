package main.java.ru.archi;

import main.java.ru.archi.caches.FirstDB;

import java.lang.reflect.Field;

/**
 * Created by Черный on 13.10.2017.
 */
public class ClassInjector {
    private static final String path = "main.java.ru.archi.caches";

    public static void putCache(Object object){
        Class cacheClass = object.getClass();

        System.out.println(cacheClass.getAnnotation(CacheDeclaration.class));



        Field cacheNameField = null;
        String cacheName = null;
        try {
            cacheNameField = cacheClass.getDeclaredField("cache");
            cacheNameField.setAccessible(true);

            cacheNameField.set(object, new FirstDB());
            cacheName = cacheNameField.get(object).getClass().getSimpleName();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(cacheName);
    }
}
