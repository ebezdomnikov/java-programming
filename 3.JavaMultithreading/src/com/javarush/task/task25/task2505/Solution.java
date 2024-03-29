package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {



    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
           // setDaemon(true);
        }

        public String toString() {
            return this.secretKey;
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
        {
            public MyUncaughtExceptionHandler()
            {

            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                //super secret key, Thread-0, it's an example

                System.out.println(String.format("%s, %s, %s",secretKey,t.getName(),e.getMessage()));
            }
        }
    }

}

