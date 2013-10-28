package sandbox.errorlogging.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import sandbox.errorlogging.framework.FrameworkError;
import sandbox.errorlogging.framework.FrameworkException;
import sandbox.errorlogging.framework.TekniskeFeil;

public class ApplicationErrorsTest {
    private ApplicationErrors applicationErrors = TekniskeFeil.instans(ApplicationErrors.class);
    private ApplicationErrorFactory errorFactory = new ApplicationErrorFactory();

    @Test
    public void skalFinneInformasjonIAnnotering() {
        FrameworkException exception = errorFactory.newFrameworkException(applicationErrors.somethingIsWrong());

        assertEquals("APP-6001", exception.getCode());
        assertEquals("Something is wrong", exception.getMessage());
        assertEquals(FrameworkError.Severity.Warning, exception.getSeverity());
        assertNotNull(exception.errorInstanceId());
    }

    @Test
    public void skalFinneInformasjonIArgumenter() {
        FrameworkException exception = errorFactory.newFrameworkException(applicationErrors.somethingIsSeriouslyWrong("the state of Denmark"));

        assertEquals("APP-6002", exception.getCode());
        assertEquals("Something in the state of Denmark is seriously wrong", exception.getMessage());
        assertEquals(FrameworkError.Severity.Error, exception.getSeverity());
    }

    @Test
    public void skalFungereMedStandardExceptions() {
        RuntimeException exception = errorFactory.newRuntimeException(applicationErrors.somethingIsWrong());

        assertEquals("APP-6001 - Something is wrong", exception.getMessage());
    }

    @Test
    public void skalFungereMedApplikasjonsspesifikkeExceptions() {
        ApplicationException exception = errorFactory.newApplicationException(applicationErrors.somethingIsWrong(), 42);

        assertEquals("APP-6001", exception.getCode());
        assertEquals("Something is wrong", exception.getMessage());
        assertEquals(FrameworkError.Severity.Warning, exception.getSeverity());
        assertEquals(42, exception.randomNumber());
    }

}
