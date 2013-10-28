package sandbox.errorlogging.framework;

public class ErrorFactory {
    public FrameworkException newFrameworkException(FrameworkError error) {
        return new FrameworkException(error);
    }

    public RuntimeException newRuntimeException(FrameworkError error) {
        return new RuntimeException(error.code() + " - " + error.details());
    }
}
