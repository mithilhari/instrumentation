package testinstrumentation;

import java.lang.instrument.Instrumentation;
// Build Dependency graph of bytecode
// If method is part of JDK ignore
public class DependencyInstrumentation {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello World Agent works fine!");;
    }
}
