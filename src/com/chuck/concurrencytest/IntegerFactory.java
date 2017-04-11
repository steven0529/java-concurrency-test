package com.chuck.concurrencytest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chuck on 11/04/2017.
 */
public class IntegerFactory {

    private Queue<Integer> integerQueue;

    public IntegerFactory() {
        this.integerQueue = new LinkedList<>();
    }

    public synchronized void putInteger(int integer) {
        this.integerQueue.add(integer);
    }

    public synchronized void consumerInteger(Consumer consumer) {
        if (integerQueue.size() > 0) {
            int polledInt = integerQueue.poll();
            consumer.consume(polledInt);
        }
    }
}
