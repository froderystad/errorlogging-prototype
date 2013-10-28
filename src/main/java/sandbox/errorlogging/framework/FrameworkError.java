package sandbox.errorlogging.framework;

public interface FrameworkError {
    String code();

    String details();

    Severity severity();

    enum Severity {
        Error,
        Warning
    }

}
