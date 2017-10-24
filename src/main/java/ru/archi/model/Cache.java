package main.java.ru.archi.model;

/**
 * Created by Черный on 12.10.2017.
 */
public interface Cache {
    void put(Integer integer, String string);
    String get(Integer integer);
}
