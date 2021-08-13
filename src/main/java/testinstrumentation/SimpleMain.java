package testinstrumentation;

import java.util.HashMap;
import testinstrumentation.Test;
import testinstrumentation.Dog;
public class SimpleMain {
    public static void main(String [] args) {
        System.out.println("Printing in main");
        SimpleMain s = new SimpleMain();
        HashMap<String,String> h = new HashMap<String,String>();
        h.put("hello", "here");
        s.f();
        Test t = new Test();
        Dog d = new Dog();
        t.methodOne();
    }

    public void f() {
        System.out.println("Printing in f");
    }

}
