public interface InterfaceDemo {
    static void sayHello() {
        System.out.println("Hello!");
    }

    default void doStuff() {
        System.out.println("Hello default");
    }

}
