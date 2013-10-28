package sandbox.errorlogging.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class TekniskeFeil extends Proxy {
    /**
     * Constructs a new {@code Proxy} instance from a subclass
     * (typically, a dynamic proxy class) with the specified value
     * for its invocation handler.
     *
     * @param h the invocation handler for this proxy instance
     */
    private TekniskeFeil(InvocationHandler h) {
        super(h);
    }


    public static <T> T instans(Class<T> clazz) {
        //noinspection unchecked
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {

            @Override
            public FrameworkError invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
                final ErrorDefinition annotation = method.getAnnotation(ErrorDefinition.class);

                return new FrameworkError() {

                    @Override
                    public String code() {
                        return annotation.code();
                    }

                    @Override
                    public String details() {
                        return String.format(annotation.details(), args);
                    }

                    @Override
                    public Severity severity() {
                        return annotation.severity();
                    }
                };
            }
        });
    }
}
