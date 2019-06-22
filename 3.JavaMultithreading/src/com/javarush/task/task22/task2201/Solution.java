package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName)
    {
        try {
            int begin = -1, end = -1;

            for (int i = 0; i < string.length(); i++) {
                if (begin == -1 && string.charAt(i) == 9) {
                    begin = i+1;
                    //System.out.println(threadName + ": " + begin);
                } else if (begin != -1 && string.charAt(i) == 9) {
                    end = i;
                }
            }

            return string.substring(begin,end);

        } catch (StringIndexOutOfBoundsException e)
        {
            if (threadName == Solution.FIRST_THREAD_NAME) {
                throw new TooShortStringFirstThreadException(e);
            }
            if (threadName == Solution.SECOND_THREAD_NAME) {
                throw new TooShortStringSecondThreadException(e);
            }

            throw new RuntimeException(e);
        }
    }
}
