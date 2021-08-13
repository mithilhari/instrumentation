package testinstrumentation;

import java.lang.instrument.Instrumentation;
import testinstrumentation.MethodDependencies;

public class TestMain {
    public static void premain(String agentArguments, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MethodDependencies());
    }
}
