package classes;

public class SingletonEagerImplementation {
    private static final SingletonEagerImplementation instance = new SingletonEagerImplementation();

    private SingletonEagerImplementation() {}

    public static SingletonEagerImplementation getInstance() {
        return instance;
    }
}
