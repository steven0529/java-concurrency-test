package com.chuck.concurrencytest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chuck on 11/04/2017.
 */
public class IntegerManager {

    private Queue<Integer> integerQueue;

    public IntegerManager() {
        this.integerQueue = new LinkedList<>();
    }

    public synchronized void putInteger(int integer) {
        this.integerQueue.add(integer);
        notifyAll();
    }

    public synchronized int getInteger() throws InterruptedException {
        while (integerQueue.size() == 0) {
            wait();
        }
        return integerQueue.remove();
    }
}
