package ru.otus.cachehw.cache;

public interface MyCache<K, V> {

    void put(K key, V val);

    V get(K key);
}
