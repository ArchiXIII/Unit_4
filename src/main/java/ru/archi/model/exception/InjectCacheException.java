package main.java.ru.archi.model.exception;

/**
 * Created by Черный on 24.10.2017.
 */
public class InjectCacheException extends Exception {

    public InjectCacheException(String message, Exception e) {
        super(message, e);
    }
}
