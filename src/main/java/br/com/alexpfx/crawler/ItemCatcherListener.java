package br.com.alexpfx.crawler;

/**
 * Created by alexandre on 17/05/2016.
 */
public interface ItemCatcherListener <T> {
    void receive (T item);
}
