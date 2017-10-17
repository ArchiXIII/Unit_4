package main.java.ru.archi.caches;

import main.java.ru.archi.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Черный on 12.10.2017.
 */
public class FirstDB implements Cache {
    private List<String> firstList = null;

    public FirstDB(){
        firstList = new ArrayList();
    }

    @Override
    public void put(Integer integer, String string) {
        if(integer < firstList.size()){
            firstList.add(integer, string);
        }
        firstList.add(string);
    }

    @Override
    public String get(Integer integer) {
        return firstList.get(integer);
    }
}
