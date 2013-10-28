package sandbox.errorlogging.application;

import static sandbox.errorlogging.framework.FrameworkError.Severity.Error;
import static sandbox.errorlogging.framework.FrameworkError.Severity.Warning;

import sandbox.errorlogging.framework.FrameworkError;
import sandbox.errorlogging.framework.ErrorDefinition;

public interface ApplicationErrors {

    @ErrorDefinition(code = "APP-6001", details = "Something is wrong", severity = Warning)
    FrameworkError somethingIsWrong();

    @ErrorDefinition(code = "APP-6002", details = "Something in %s is seriously wrong", severity = Error)
    FrameworkError somethingIsSeriouslyWrong(String where);

}
