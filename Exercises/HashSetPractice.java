import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetPractice {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(5);
        numbers.add(5);
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        numbers.add(25);

        System.out.println(numbers);

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(5);
        numbers2.add(3);
        numbers2.add(4);
        numbers2.add(4);
        numbers2.add(2);
        numbers2.add(5);

        System.out.println(numbers2);

        HashSet<Integer> numbers3 = new HashSet<>();
        numbers3.addAll(numbers2);

        System.out.println(numbers3);
    }
}
