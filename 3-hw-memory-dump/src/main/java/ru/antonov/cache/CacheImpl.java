package ru.antonov.cache;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheImpl<K, V> implements Cache<K, V> {

//    private final Map<K, V> CACHE = new ConcurrentHashMap<>();
    private final Map<K, V> CACHE = Collections.synchronizedMap(new WeakHashMap<>());

    @Override
    public V get(K key) {
        return CACHE.get(key);
    }

    @Override
    public void put(K key, V val) {
        CACHE.put(key, val);
    }
}
