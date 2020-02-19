package testinstrumentation;

import org.brutusin.instrumentation.Interceptor;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class MyInterceptor extends Interceptor {

    @Override
    public void init(String arg) {
        System.out.println("Interceptor args: " + arg);
    }

    @Override
    public boolean interceptClass(String className, byte[] byteCode) {
        return className.endsWith("SimpleClass"); // all classes can be intrumented
    }

    @Override
    public boolean interceptMethod(ClassNode cn, MethodNode mn) {
        return true; // all methods are instrumented
    }

    @Override
    protected void doOnStart(Object m, Object[] arg, String executionId) {
        System.out.println("doOnStart " + m + " " + executionId);
    }

    @Override
    protected void doOnThrowableThrown(Object m, Throwable throwable, String executionId) {
        System.out.println("doOnThrowableThrown " + m + " " + executionId);
    }

    @Override
    protected void doOnThrowableUncatched(Object m, Throwable throwable, String executionId) {
        System.out.println("doOnThrowableUncatched " + m + " " + executionId);
    }

    @Override
    protected void doOnFinish(Object m, Object result, String executionId) {
        System.out.println("doOnFinish " + m + " " + executionId);
    }
}