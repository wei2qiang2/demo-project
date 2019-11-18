package com.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerAsyncTask implements Runnable {


    @Override
    public void run() {
        LinkedBlockingQueue<User> blockingQueue = BlockQueueDataProducer.blockingQueue;


    }
}
