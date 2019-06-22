package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue();

    public static void main(String[] args) {
//        Tablet tablet = new Tablet(5);
//        Cook firstCook = new Cook("Amigo");
//        Waiter firstWaiter = new Waiter();
//        tablet.addObserver(firstCook);
//        firstCook.addObserver(firstWaiter);
//        tablet.createOrder();

        Cook cook1 = new Cook("Vova");
        Cook cook2 = new Cook("Petr");
        cook1.setQueue(orderQueue);
        cook2.setQueue(orderQueue);

        Thread cook1Thread=new Thread(cook1);
        cook1Thread.start();
        Thread cook2Thread=new Thread(cook2);
        cook2Thread.start();

        StatisticManager.getInstance().register(cook1);
        StatisticManager.getInstance().register(cook2);
        

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tabletList.add(tablet);
            //tablet.addObserver(cook1);
            //tablet.addObserver(cook2);
        }

        Thread randomOrderThread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        randomOrderThread.start();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}