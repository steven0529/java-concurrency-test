package com.chuck.concurrencytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chuck on 11/04/2017.
 */
public class Consumer extends Thread {

    private String consumerName;
    private List<Integer> integerList = new ArrayList<>();
    private IntegerManager integerManager;

    public Consumer(IntegerManager integerManager, String consumerName) {
        this.integerManager = integerManager;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        while (integerList.size() < Constants.CONSUMER_MAX_CONSUME_COUNT) {
            try {
                int integer = integerManager.getInteger();
                System.out.println("Consume: " + consumerName + " consuming " + integer);
                integerList.add(integer);
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(integerList);
        System.out.println("Sorted Array: " + consumerName + " " + integerList.toString());
    }


}
