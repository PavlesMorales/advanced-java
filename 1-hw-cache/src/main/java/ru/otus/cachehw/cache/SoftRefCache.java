package ru.otus.cachehw.cache;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

public class SoftRefCache<K, V> extends AbstractCache<K, V> {

    public SoftRefCache(Map<K, Reference<V>> cache) {
        super(cache);
    }

    @Override
    public Reference<V> createRef(V val) {
        return new WeakReference<>(val);
    }
}
