package lab7;

import java.util.LinkedList;
import java.util.Queue;

public class ActivationQueue {
    private final Queue<MethodRequest> activationQueue = new LinkedList<>();


    public synchronized void enqueue(MethodRequest request) {
        activationQueue.add(request);
        this.notifyAll();
    }

    public synchronized MethodRequest dequeue() {
        while (activationQueue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        MethodRequest request = activationQueue.poll();

        return request;
    }
}
