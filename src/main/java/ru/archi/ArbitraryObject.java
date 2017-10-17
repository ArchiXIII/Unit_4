package main.java.ru.archi;

/**
 * Created by Черный on 17.10.2017.
 */
@CacheDeclaration(name = "ArbitraryObject")
public class ArbitraryObject {
    int cacheNumber;

    @InjectCache
    private Cache cache;

    public ArbitraryObject(int cacheNumber){
        this.cacheNumber = cacheNumber;
    }

    public int getCacheNumber(){
        return cacheNumber;
    }
}
