package main.java.ru.archi.model.objects_for_test;

import main.java.ru.archi.model.Cache;
import main.java.ru.archi.model.annotations.InjectCache;

/**
 * Created by Черный on 24.10.2017.
 */
public class ArbitraryObjectHeir extends ArbitraryObject {
    @InjectCache(cacheName = "GreenDataStore")
    private Cache greenCache;

    @Override
    public void printCache() {
        if (greenCache != null) {
            System.out.println("Placed greenCache - " + greenCache.getClass().getSimpleName());
            System.out.println("Data from the greenCache - " + greenCache.get(0));
        } else {
            System.out.println("There is no greenCache");
        }
    }
}
