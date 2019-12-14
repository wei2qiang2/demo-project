package com.thread;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockQueueDataProducer {

    public static LinkedBlockingQueue<User> blockingQueue = new LinkedBlockingQueue<>();

    public static LinkedBlockingQueue<User> produceData() throws InterruptedException {
        for (long i = 0; i < 1000000; i++) {
            User u = new User();
            u.setId(i);
            u.setName(UUID.randomUUID().toString());
            blockingQueue.put(u);
        }
        return blockingQueue;
    }
}
