package main.java.ru.archi;


import java.util.List;

/**
 * Created by Черный on 13.10.2017.
 */
public class Controller {
    public static void executionProgramLogic(){
        List<Cache> caches = Caches.getObjectsCache();

        ArbitraryObject arbitraryObject = new ArbitraryObject();

        ClassInjector injector = new ClassInjector(caches);
        injector.putCache(arbitraryObject);

        arbitraryObject.printCache();
    }
}
