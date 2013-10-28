package sandbox.errorlogging.framework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ErrorDefinition {
    String code();
    String details();
    FrameworkError.Severity severity();
}
