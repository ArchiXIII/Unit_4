package main.java.ru.archi.controller;


import main.java.ru.archi.model.objects_for_test.ArbitraryObject;
import main.java.ru.archi.model.Cache;
import main.java.ru.archi.model.Caches;
import main.java.ru.archi.model.ClassInjector;
import main.java.ru.archi.model.exception.InjectCacheException;
import main.java.ru.archi.model.objects_for_test.ArbitraryObjectHeir;

import java.util.Map;

/**
 * Created by Черный on 13.10.2017.
 */
public class Controller {
    public static void executionProgramLogic(){
        Map<String, Cache> caches = Caches.getObjectsCache();

        //ArbitraryObject arbitraryObject = new ArbitraryObject();
        ArbitraryObject arbitraryObject = new ArbitraryObjectHeir();

        ClassInjector injector = new ClassInjector(caches);
        try {
            injector.putCache(arbitraryObject);
        } catch (InjectCacheException e) {
            System.out.println(e);
        }

        arbitraryObject.printCache();
    }
}
