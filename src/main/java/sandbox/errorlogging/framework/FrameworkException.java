package sandbox.errorlogging.framework;

import java.util.UUID;

public class FrameworkException extends RuntimeException {
    private FrameworkError error;
    private UUID errorInstanceId;

    protected FrameworkException(FrameworkError error) {
        super(error.details());
        this.error = error;
        this.errorInstanceId = UUID.randomUUID();
    }

    public String getCode() {
        return error.code();
    }

    public FrameworkError.Severity getSeverity() {
        return error.severity();
    }

    public UUID errorInstanceId() {
        return errorInstanceId;
    }
}
