package lab7;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private final static int PROD_COUNT = 3;
    private final static int CONS_COUNT = 5;
    private final static int MAX_BUF_SIZE = 10;

    public static void main(String[] argv) throws InterruptedException {
        BufferProxy proxy = new BufferProxy(MAX_BUF_SIZE);

        Thread[] producers = new Thread[PROD_COUNT];
        Thread[] consumers = new Thread[CONS_COUNT];

        for (int i = 0; i < PROD_COUNT; i++) {
            int finalI = i;
            producers[i] = new Thread(() -> {
                Producer p = new Producer(finalI, proxy, ThreadLocalRandom.current());
                p.run();
            });
            producers[i].start();
        }

        for (int i = 0; i < CONS_COUNT; i++) {
            consumers[i] = new Thread(new Consumer(i, proxy));
            consumers[i].start();
        }

        for (int i = 0; i < PROD_COUNT; i++) {
            producers[i].join();
        }

        for (int i = 0; i < CONS_COUNT; i++) {
            consumers[i].join();
        }
    }
}
