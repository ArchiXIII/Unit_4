package main.java.ru.archi.model;

import main.java.ru.archi.model.annotations.InjectCache;
import main.java.ru.archi.model.exception.InjectCacheException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * Created by Черный on 13.10.2017.
 */
public class ClassInjector {
    private Map<String, Cache> caches = null;

    public ClassInjector(Map<String, Cache> caches){
        this.caches = caches;
    }

    public void putCache(Object object) throws InjectCacheException {
        Class cacheClass = object.getClass();
        Field[] fields = cacheClass.getDeclaredFields();

        try {
            for (Field field : fields) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                InjectCache a = field.getAnnotation(InjectCache.class);

                for (Map.Entry<String, Cache> entry : caches.entrySet()) {
                    if (a != null && entry.getKey().equals(a.cacheName())) {
                        field.set(object, entry.getValue());
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new InjectCacheException("Could not inject cache", e);
        }
    }
}
