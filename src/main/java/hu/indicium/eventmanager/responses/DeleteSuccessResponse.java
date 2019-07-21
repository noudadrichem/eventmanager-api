package hu.indicium.eventmanager.responses;

public class DeleteSuccessResponse extends Response {
    public DeleteSuccessResponse() {
        super(new DeleteStatus(true), null);
    }
}
