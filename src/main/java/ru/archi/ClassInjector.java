package main.java.ru.archi;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Черный on 13.10.2017.
 */
public class ClassInjector {
    List<Cache> caches = null;

    public ClassInjector(List<Cache> caches){
        this.caches = caches;
    }

    public void putCache(Object object){
        Class cacheClass = object.getClass();

        //System.out.println(cacheClass.getAnnotation(CacheDeclaration.class));

        try {
            Field[] fields = cacheClass.getDeclaredFields();
            Field field = null;
            InjectCache a = null;

            for(int i = 0; i < fields.length; i++){
                field = fields[i];
                field.setAccessible(true);
                a = field.getAnnotation(InjectCache.class);
                if(a != null){
                    Class<?> type = a.annotationType();
                }
            }

            for(int i = 0; i < caches.size(); i++) {
                if(caches.get(i).getClass().getSimpleName().equals(a.cacheName())) {
                    field.set(object, caches.get(i));
                }
            };
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }
}
