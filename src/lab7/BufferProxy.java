package lab7;

public class BufferProxy {
    private final Buffer<Integer> buffer;
    private final Scheduler scheduler = new Scheduler();

    public BufferProxy(int maxSize) {
        buffer = new Buffer<>(maxSize);
        scheduler.start();
    }

    public MyFuture<Void> add(Integer item) {
        MyFuture<Void> result =  new MyFuture<>();
        scheduler.enqueue(new AddRequest<>(buffer, item));
        return result;
    }

    public MyFuture<Integer> get() {
        MyFuture<Integer> result = new MyFuture<>();

        scheduler.enqueue(new GetRequest<>(buffer, result));

        return result;
    }
}
