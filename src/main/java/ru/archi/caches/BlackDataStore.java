package main.java.ru.archi.caches;

import main.java.ru.archi.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Черный on 12.10.2017.
 */
public class BlackDataStore implements Cache {
    List<String> thirdList = new ArrayList();

    @Override
    public void put(Integer integer, String string) {
        if(integer < thirdList.size()){
            thirdList.add(integer, string);
        }
        thirdList.add(string);
    }

    @Override
    public String get(Integer integer) {
        return thirdList.get(integer);
    }
}
