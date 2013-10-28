package sandbox.errorlogging.application;

import sandbox.errorlogging.framework.FrameworkError;
import sandbox.errorlogging.framework.FrameworkException;

public class ApplicationException extends FrameworkException {
    private int randomNumber;

    ApplicationException(FrameworkError frameworkError, int randomNumber) {
        super(frameworkError);
        this.randomNumber = randomNumber;
    }

    public int randomNumber() {
        return randomNumber;
    }
}
