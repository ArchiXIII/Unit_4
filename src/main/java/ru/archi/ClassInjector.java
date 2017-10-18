package main.java.ru.archi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Черный on 13.10.2017.
 */
public class ClassInjector {
    private static final String CACHES_PATH = "main.java.ru.archi.caches";

    public static void putCache(Object object){
        Class cacheClass = object.getClass();

        System.out.println(cacheClass.getAnnotation(CacheDeclaration.class));

        List<Cache> caches = getObjectsCache();


        String cacheName = null;
        try {
            Field cacheNameField = cacheClass.getDeclaredField("cache");
            cacheNameField.setAccessible(true);

            Random random = new Random();
            cacheNameField.set(object, caches.get(random.nextInt(caches.size())));
            cacheName = cacheNameField.get(object).getClass().getSimpleName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e);
        }

        System.out.println("Placed cache - " + cacheName);
    }

    private static List<Cache> getObjectsCache(){
        List<Cache> caches = new ArrayList<>();

        String packageDir = CACHES_PATH.replaceAll("[.]", "/");
        ClassLoader classLoader = ClassInjector.class.getClassLoader();
        URL urlPackage = classLoader.getResource(packageDir);

        try {
            InputStream in = (InputStream) urlPackage.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if(line.endsWith(".class")) {
                    Class<?> c = Class.forName(CACHES_PATH + "." + line.substring(0, line.lastIndexOf('.')));
                    Constructor<?> cons = c.getConstructor();
                    caches.add((Cache) cons.newInstance());
                }
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }

        return caches;
    }
}
