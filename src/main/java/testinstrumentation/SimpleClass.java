package testinstrumentation;

public class SimpleClass {
    public static String sayHello(String name) {
        return "Hello " + name + ", you fool, I love youuu! " + joinTheJoyRide();
    }

    public static String joinTheJoyRide() {
        return "C'mon join the joyrideee!";
    }

    public static String sayGoodBye() {
        return "Goodbye to you, goodbye to broken hearts";
    }

    public static void main(String [] args) {
        System.out.println("Running SimpleClass main");
    }
}
