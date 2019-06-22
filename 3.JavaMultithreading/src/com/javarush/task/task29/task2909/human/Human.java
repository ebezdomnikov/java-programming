package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {

    public class Size {
        public int height;
        public int weight;
    }

    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size;

    private BloodGroup bloodGroup;

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        this.children.add(human);
    }

    public void removeChild(Human human) {
        this.children.remove(human);
    }

    public void setBloodGroup(BloodGroup group) {
        bloodGroup = group;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {

    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData() {
        System.out.println(this.getPosition() + ": " + name);
    }

    public String getPosition() {
        return "Человек";
    }
}