package com.demo.jvm.load;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private volatile boolean isRunning = true;
    private BlockingQueue queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    public void stop(){
        this.isRunning = false;
    }

    @Override
    public void run() {

        String data = null;
        Random r = new Random();
        System.out.println("producer is start...");
        try{
            while (isRunning){

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
