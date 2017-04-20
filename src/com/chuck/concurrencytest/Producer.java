package com.chuck.concurrencytest;

import java.util.Random;

/**
 * Created by chuck on 11/04/2017.
 */
public class Producer extends Thread {

    private Random r;
    private IntegerManager integerManager;
    private String producerName;

    public Producer(IntegerManager integerManager, String producerName) {
        this.r = new Random();
        this.integerManager = integerManager;
        this.producerName = producerName;
    }

    @Override
    public void run() {
        for (int i = 0; i < Constants.PRODUCER_EMIT_COUNT; i++) {
            try {
                int randomInt = r.nextInt(100);
                System.out.println("Produce: " + producerName + " producing " + randomInt);
                integerManager.putInteger(randomInt);
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.stop();
    }
}
