package lab7;


public class Scheduler {
    private final ActivationQueue activationQueue = new ActivationQueue();


    public void enqueue(MethodRequest request) {
        activationQueue.enqueue(request);
    }


    public void start() {
        Thread t = new Thread(() -> {
            while (true) {
                MethodRequest request = activationQueue.dequeue();

                if (request.guard()) {
                    request.call();
                } else {
                    activationQueue.enqueue(request);
                }
            }
        });

        t.start();
    }
}