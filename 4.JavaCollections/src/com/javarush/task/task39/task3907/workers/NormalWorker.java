package com.javarush.task.task39.task3907.workers;

public class NormalWorker implements Worker, Eater,Sleeper {
    public void work() {
        System.out.println("NormalWorker is working!");
    }

    public void eat() {
        System.out.println("NormalWorker is eating!");
    }

    public void sleep() {
        System.out.println("NormalWorker is sleeping!");
    }
}
