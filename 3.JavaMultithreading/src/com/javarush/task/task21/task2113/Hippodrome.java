package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome
{
    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List horses)
    {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException
    {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Molly", 3, 0));
        horses.add(new Horse("Holly", 3, 0));
        horses.add(new Horse("Dolly", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException {
        for(int i=0; i<100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (int i=0; i<horses.size(); i++)
        {
            horses.get(i).move();
        }
    }

    public void print()
    {
        for (int i=0; i<horses.size(); i++)
        {
            horses.get(i).print();
        }

        for (int j=0; j<10; j++) {
            System.out.println();
        }
    }

    public Horse getWinner()
    {
        double max = 0;
        Horse winner = null;

        for(int i=0; i<horses.size(); i++) {

            if (horses.get(i).getDistance() > max) {
                max = horses.get(i).getDistance();
                winner = horses.get(i);
            }
        }

        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
