package main.java.ru.archi.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Черный on 18.10.2017.
 */
public class Caches {
    private static final String CACHES_PATH = "main.java.ru.archi.model.caches";

    public static Map<String, Cache> getObjectsCache(){
        Map<String, Cache> caches = new HashMap<>();

        String packageDir = CACHES_PATH.replaceAll("[.]", "/");
        ClassLoader classLoader = ClassInjector.class.getClassLoader();
        URL urlPackage = classLoader.getResource(packageDir);

        try {
            InputStream in = (InputStream) urlPackage.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                if(line.endsWith(".class")) {
                    Class<?> c = Class.forName(CACHES_PATH + "." + line.substring(0, line.lastIndexOf('.')));
                    Constructor<?> cons = c.getConstructor();
                    Object obj = cons.newInstance();
                    if (obj instanceof Cache) {
                        caches.put(obj.getClass().getSimpleName(), (Cache) obj);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }

        addDataToCaches(caches);
        return caches;
    }

    private static void addDataToCaches(Map<String, Cache> caches){
        for(Cache cache : caches.values()){
            cache.put(0, "... " + cache.getClass().getSimpleName() + " Caches data " + "...");
        }
    }
}
