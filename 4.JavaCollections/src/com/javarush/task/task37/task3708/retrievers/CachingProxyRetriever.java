package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever originalRetriever;
    private LRUCache cache;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
        this.cache = new LRUCache(10);
    }


    @Override
    public Object retrieve(long id) {
        Object cached = cache.find(id);
        if (cached != null) {
            return cached;
        }

        Object orig = originalRetriever.retrieve(id);

        cache.set(id, orig);

        return orig;
    }
}
