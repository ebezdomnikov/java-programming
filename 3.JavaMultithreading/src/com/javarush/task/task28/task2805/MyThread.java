package com.javarush.task.task28.task2805;

public class MyThread extends Thread {

    protected static int prio = 0;

    protected static void getNextPrio(Thread thread) {
        prio++;
        if (prio > Thread.MAX_PRIORITY) {
            prio = Thread.MIN_PRIORITY;
        }

        thread.setPriority(prio);
    }

    protected static void getNextPrioForGroup(ThreadGroup group, Thread thread) {
        prio++;
        if (prio > Thread.MAX_PRIORITY) {
            prio = Thread.MIN_PRIORITY;
        }

        if (prio > group.getMaxPriority()) {
            thread.setPriority(group.getMaxPriority());
        } else {
            thread.setPriority(prio);
        }
    }

    public MyThread() {
        getNextPrio(this);
    }

    public MyThread(Runnable target) {
        super(target);
        getNextPrio(this);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        getNextPrioForGroup(group, this);
    }

    public MyThread(String name) {
        super(name);
        getNextPrio(this);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        getNextPrioForGroup(group, this);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        getNextPrio(this);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        getNextPrioForGroup(group, this);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        getNextPrioForGroup(group, this);
    }
}
