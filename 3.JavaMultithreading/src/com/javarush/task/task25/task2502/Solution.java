package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            try {
                wheels = new ArrayList<>();
                String[] list = this.loadWheelNamesFromDB();
                for (int i=0; i<list.length; i++) {
                    wheels.add(Wheel.valueOf(list[i]));
                }

                if (list.length > 4 || list.length<4) {
                    throw new Exception();
                }

            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

        Car car = new Car();

    }
}
