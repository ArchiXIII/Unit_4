package main.java.ru.archi;

import main.java.ru.archi.caches.FirstDB;

/**
 * Created by Черный on 13.10.2017.
 */
public class Controller {
    public static void main(String[] args) {
        ClassInjector.putCache(new FirstDB());
    }
}
