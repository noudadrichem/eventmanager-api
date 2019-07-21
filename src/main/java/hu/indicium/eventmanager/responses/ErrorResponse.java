package hu.indicium.eventmanager.responses;

public class ErrorResponse extends Response {
    public ErrorResponse(Object error) {
        super(null, error);
    }
}
