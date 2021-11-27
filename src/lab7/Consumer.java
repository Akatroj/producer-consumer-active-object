package lab7;

public class Consumer implements Runnable {
    private final int id;
    private final BufferProxy proxy;

    public Consumer(int id, BufferProxy proxy) {
        this.id = id;
        this.proxy = proxy;
    }

    public void run() {
        while(true) {
            MyFuture<Integer> result = proxy.get();
            System.out.println("Konsument " + id + " wyjal: " + result.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
