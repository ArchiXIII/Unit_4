package main.java.ru.archi;

/**
 * Created by Черный on 17.10.2017.
 */
@CacheDeclaration(cacheName = "GreenDataStore")
public class ArbitraryObject {
    @InjectCache(cacheName = "GreenDataStore")
    private Cache cache;

    public void printCache(){
        System.out.println("Placed cache - " + cache.getClass().getSimpleName());
        System.out.println("Data from the cache - " + cache.get(0));
    }
}
