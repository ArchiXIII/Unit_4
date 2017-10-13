package main.java.ru.archi.caches;

import main.java.ru.archi.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Черный on 12.10.2017.
 */
public class SecondDB implements Cache {
    List<String> secondList = new ArrayList();

    @Override
    public void put(Integer integer, String string) {
        if(integer < secondList.size()){
            secondList.add(integer, string);
        }
        secondList.add(string);
    }

    @Override
    public String get(Integer integer) {
        return secondList.get(integer);
    }
}
