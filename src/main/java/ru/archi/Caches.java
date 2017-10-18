package main.java.ru.archi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Черный on 18.10.2017.
 */
public class Caches {
    private static final String CACHES_PATH = "main.java.ru.archi.caches";

    public static List<Cache> getObjectsCache(){
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

        addDataToCaches(caches);
        return caches;
    }

    private static void addDataToCaches(List<Cache> caches){
        for(int i=0; i < caches.size(); i++){
            caches.get(i).put(0, "Cache data №" + i);
        }
    }
}
