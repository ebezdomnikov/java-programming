package com.javarush.task.task20.task2024;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

//    public void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException
//    {
//        objectOutputStream.defaultWriteObject();
//        for (Solution edge: edges) {
//            if (node != edge.node) {
//                edge.writeObject(objectOutputStream);
//            }
//        }
//    }
//
//
//
//    public void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
//        objectInputStream.defaultReadObject();
//
//    }


    public static void main(String[] args)
    {

    }
}
