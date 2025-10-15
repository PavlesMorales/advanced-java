package ru.otus.cachehw.cache;

import java.lang.ref.Reference;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractCache<K, V> implements MyCache<K, V> {

    private final Map<K, Reference<V>> cache;

    public AbstractCache(Map<K, Reference<V>> cache) {
        this.cache = cache;
    }

    @Override
    public void put(K key, V val) {
        cache.put(key, createRef(val));
    }

    @Override
    public V get(K key) {
        final Reference<V> vReference = cache.get(key);
        if (Objects.nonNull(vReference)) {
            final V value = vReference.get();
            if (Objects.isNull(value)) {
                cache.remove(key);
                return null;
            } else {
                return value;
            }
        }
        return null;
    }

    public abstract Reference<V> createRef(V val);
}
