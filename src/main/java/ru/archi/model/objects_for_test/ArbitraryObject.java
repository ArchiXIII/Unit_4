package main.java.ru.archi.model.objects_for_test;

import main.java.ru.archi.model.Cache;
import main.java.ru.archi.model.annotations.InjectCache;

/**
 * Created by Черный on 17.10.2017.
 */
public class ArbitraryObject {
    @InjectCache(cacheName = "BlackDataStore")
    private Cache blackCache;

    @InjectCache(cacheName = "WhiteDataStore")
    private Cache whiteCache;

    public void printCache(){
        if (blackCache != null) {
            System.out.println("Placed blackCache - " + blackCache.getClass().getSimpleName());
            System.out.println("Data from the blackCache - " + blackCache.get(0));
        } else {
            System.out.println("There is no blackCache");
        }
        if (whiteCache != null) {
            System.out.println("Placed whiteCache - " + whiteCache.getClass().getSimpleName());
            System.out.println("Data from the whiteCache - " + whiteCache.get(0));
        } else {
            System.out.println("There is no whiteCache");
        }
    }
}
