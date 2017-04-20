package com.chuck.concurrencytest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuck on 11/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        IntegerManager intFactory = new IntegerManager();
        Producer producerThread = new Producer(intFactory, "Producer A");

        List<Consumer> consumerList = new ArrayList<>();

        for (int i = 0; i < Constants.CONSUMER_COUNT; i++) {
            Consumer consumer = new Consumer(intFactory, "Consumer " + (i + 1));
            consumerList.add(consumer);
        }

        producerThread.start();
        for (int i = 0; i < Constants.CONSUMER_COUNT; i++)
            consumerList.get(i).start();
    }
}
