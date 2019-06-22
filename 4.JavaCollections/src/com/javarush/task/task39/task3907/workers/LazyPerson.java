package com.javarush.task.task39.task3907.workers;

public class LazyPerson implements Eater, Sleeper {
    public void eat() {
        System.out.println("LazyPerson is eating!");
    }

    public void sleep() {
        System.out.println("LazyPerson is sleeping!");
    }
}
