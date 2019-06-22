package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread  {

    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    public void run()
    {
        State currentState = target.getState();
        System.out.println(currentState);
        super.run();
        while (!currentState.equals(State.TERMINATED)) {
            State newState = target.getState();
            if (!newState.equals(currentState)) {
                System.out.println(newState);
                currentState = newState;
            }
        }
        this.interrupt();
    }

}
