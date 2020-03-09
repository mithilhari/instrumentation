package testinstrumentation;

import java.util.HashMap;

public class SimpleMain {
    public static void main(String [] args) {
        System.out.println("Printing in main");
        SimpleMain s = new SimpleMain();
        HashMap<String,String> h = new HashMap<String,String>();
        h.put("hello", "here");
        s.f();
        Test t = new Test();
        t.methodOne();
    }

    public void f() {
        System.out.println("Printing in f");
    }

}
