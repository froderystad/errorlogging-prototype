package sandbox.errorlogging.application;

import sandbox.errorlogging.framework.FrameworkError;
import sandbox.errorlogging.framework.ErrorFactory;

public class ApplicationErrorFactory extends ErrorFactory {
    public ApplicationException newApplicationException(FrameworkError error, int randomNumber) {
        return new ApplicationException(error, randomNumber);
    }
}
