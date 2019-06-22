package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        /**
         * Обработай список нитей в зависимости от состояния:
         1. Если нить еще не запущена, то запусти ее.
         2. Если нить в ожидании, то прерви ее.
         3. Если нить работает, то проверь маркер isInterrupted.
         4. Если нить прекратила работу, то выведи в консоль ее приоритет.
         Используй switch.
         */
        for (int i=0; i<threads.length; i++) {
            Thread thread = threads[i];
            switch (thread.getState()) {
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                    thread.interrupt();
                    break;
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case BLOCKED:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    if (thread.isInterrupted()) {
                        System.out.println(thread.getPriority());
                    }
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;

            }

        }
    }

    public static void main(String[] args) {
    }
}
