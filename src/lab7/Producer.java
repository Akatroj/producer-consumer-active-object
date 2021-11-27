package lab7;

import java.util.Random;

public class Producer implements Runnable {
    private final int id;
    private final BufferProxy proxy;
    private final Random rand;

    public Producer(int id, BufferProxy proxy, Random rand) {
        this.id = id;
        this.proxy = proxy;
        this.rand = rand;
    }

    @Override
    public void run() {
        while(true) {
            int temp = rand.nextInt(100);
            proxy.add(temp);
            System.out.println("Pracownik " + id + " dodal: " + temp);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}