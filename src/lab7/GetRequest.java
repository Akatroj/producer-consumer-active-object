package lab7;

public class GetRequest<T> implements MethodRequest {
    private final Buffer<T> buffer;
    private final MyFuture<T> result;

    public GetRequest(Buffer<T> buffer, MyFuture<T> result) {
        this.buffer = buffer;
        this.result = result;
    }

    @Override
    public void call() {
        result.complete(buffer.remove());
    }

    @Override
    public boolean guard() {
        return !buffer.isEmpty();
    }
}





