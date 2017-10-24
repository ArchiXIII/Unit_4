package main.java.ru.archi.model.caches;

import main.java.ru.archi.model.Cache;
import main.java.ru.archi.model.annotations.CacheDeclaration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Черный on 12.10.2017.
 */
@CacheDeclaration(cacheName = "BlackDataStore")
public class BlackDataStore implements Cache {
    List<String> blackList = new ArrayList();

    @Override
    public void put(Integer integer, String string) {
        if(integer < blackList.size()){
            blackList.add(integer, string);
        }
        blackList.add(string);
    }

    @Override
    public String get(Integer integer) {
        return blackList.get(integer);
    }
}
