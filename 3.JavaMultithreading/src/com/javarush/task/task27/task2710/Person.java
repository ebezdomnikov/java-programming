package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        synchronized (mail) {
            String name = Thread.currentThread().getName();
            try {
                Thread.sleep(1000);
                //сделайте что-то тут - do something here
                mail.setText("Person [" + name + "] has written an email 'AAA'");
                this.notifyAll();
                //сделайте что-то тут - do something here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
