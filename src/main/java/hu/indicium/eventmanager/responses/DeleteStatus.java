package hu.indicium.eventmanager.responses;

public class DeleteStatus {
    private boolean success;

    public DeleteStatus(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
