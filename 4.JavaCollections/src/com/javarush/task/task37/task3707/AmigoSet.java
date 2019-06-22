package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;


    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<E, Object>(Integer.max(16, (int) Math.ceil(collection.size() / .75f)));
        addAll(collection);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(Object e) {
        int startsize = map.size();
        map.put((E) e, PRESENT);

        if (map.size() > startsize) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.map.keySet().toArray(a);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return super.remove(o);
    }

    @Override
    public Object clone() {
        AmigoSet copy;
        try {
            copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();

        } catch (Exception e) {
            throw new InternalError(e.getMessage(),e);
        }

        return copy;
    }

    private void writeObject(ObjectOutputStream oos) {

        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int buckets = HashMapReflectionHelper.callHiddenMethod(map, "capacity");

        try {
            oos.defaultWriteObject();
            oos.writeInt(buckets);
            oos.writeFloat(loadFactor);
            oos.writeInt(map.size());
            for (Iterator i = map.keySet().iterator(); i.hasNext(); ) oos.writeObject(i.next());
        } catch (IOException e) {

        }
    }

    private void readObject(ObjectInputStream s) {
        try {
            s.defaultReadObject();
            int bucket = s.readInt();
            float loadFactor = s.readFloat();
            map = new HashMap<E, Object>(bucket, loadFactor);
            int size = s.readInt();
            for (int i = 0; i < size; i++) {
                E e = (E)s.readObject();
                map.put(e, PRESENT);
            }

        } catch (Exception e) {

        }
    }
}
