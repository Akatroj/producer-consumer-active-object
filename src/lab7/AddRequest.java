package lab7;

public class AddRequest<T> implements MethodRequest {
    private final Buffer<T> buffer;
    private final T item;

    public AddRequest(Buffer<T> buffer, T item){
        this.buffer = buffer;
        this.item = item;
    }

    @Override
    public void call() {
        buffer.add(item);
    }

    @Override
    public boolean guard() {
        return !buffer.isFull();
    }
}