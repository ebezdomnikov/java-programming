package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        if (softReference == null) {
            return null;
        }

        return softReference.get();
    }

    public AnyObject put(Long key, AnyObject value) {

        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        /**
         * Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value.
         * Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
         * Иначе - верни предыдущее значение value по этому ключу. Не забудь вызвать метод clear()
         * у объекта типа SoftReference<AnyObject>.
         */
        if (softReference != null) {
            AnyObject o = softReference.get();
            softReference.clear();
            return o;
        } else {
            return null;
        }
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        if (softReference!=null) {
            AnyObject o = softReference.get();
            softReference.clear();
            return o;
        }

        return null;
    }
}