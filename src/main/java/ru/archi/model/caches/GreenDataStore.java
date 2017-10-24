package main.java.ru.archi.model.caches;

import main.java.ru.archi.model.Cache;
import main.java.ru.archi.model.annotations.CacheDeclaration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Черный on 12.10.2017.
 */
@CacheDeclaration(cacheName = "GreenDataStore")
public class GreenDataStore implements Cache {
    private List<String> greenList = null;

    public GreenDataStore(){
        greenList = new ArrayList();
    }

    @Override
    public void put(Integer integer, String string) {
        if(integer < greenList.size()){
            greenList.add(integer, string);
        }
        greenList.add(string);
    }

    @Override
    public String get(Integer integer) {
        return greenList.get(integer);
    }
}
