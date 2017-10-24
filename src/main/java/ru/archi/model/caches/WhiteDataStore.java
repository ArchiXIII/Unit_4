package main.java.ru.archi.model.caches;

import main.java.ru.archi.model.Cache;
import main.java.ru.archi.model.annotations.CacheDeclaration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Черный on 12.10.2017.
 */
@CacheDeclaration(cacheName = "WhiteDataStore")
public class WhiteDataStore implements Cache {
    List<String> whiteList = new ArrayList();

    @Override
    public void put(Integer integer, String string) {
        if(integer < whiteList.size()){
            whiteList.add(integer, string);
        }
        whiteList.add(string);
    }

    @Override
    public String get(Integer integer) {
        return whiteList.get(integer);
    }
}
