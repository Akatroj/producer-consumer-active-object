package lab7;

public class MyFuture<T> {
    private T content;
    private boolean isReady = false;

    public synchronized void complete(T content) {
        if (isReady) throw new IllegalStateException("Future already completed!");
        this.content = content;
        isReady = true;
        this.notifyAll();
    }

    public synchronized T get() {
        while(!isReady) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public boolean isReady() {
        return isReady;
    }
}