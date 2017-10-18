package main.java.ru.archi;

/**
 * Created by Черный on 17.10.2017.
 */
@CacheDeclaration(name = "ArbitraryObject")
public class ArbitraryObject {

    @InjectCache
    private Cache cache;
}
