import java.util.LinkedList;

public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<>();

        cars.add("Toyota");
        cars.add("Honda");
        cars.add("Tata");
        cars.add(0, "Audi");
        cars.add(1, "BMW");

        cars.addFirst("Tesla");
        cars.addLast("Suzuki");

        System.out.println(cars);

        System.out.println(cars.contains("Tesla"));

        System.out.println(cars.getFirst());
        System.out.println(cars.getLast());
        System.out.println(cars.indexOf("Toyota"));

        System.out.println(cars.peek());
        System.out.println(cars.poll());

        System.out.println(cars);

        System.out.println(cars.pop());
        System.out.println(cars);

        cars.push("Aston Martin");
        System.out.println(cars);
    }

}
