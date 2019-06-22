package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;


public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy = false;
    private volatile boolean caught = false;

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");

        String tabletName = order.getTablet().toString();
        String cookName = name;
        int cookingTimeSeconds = order.getTotalCookingTime();
        List<Dish> cookingDishs = order.getDishes();
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(tabletName, cookName,
                cookingTimeSeconds, cookingDishs);
        StatisticManager.getInstance().register(cookedOrderEventDataRow);

        setChanged();
        notifyObservers(order);
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
        }
        busy = false;
    }

    @Override
    public void run() {

        while (!busy) {
            try {
                startCookingOrder(queue.take());
            } catch (InterruptedException e) {
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                caught = true;
            }
            if (caught && queue.isEmpty()) {
                busy = true;
            }
        }
    }}
