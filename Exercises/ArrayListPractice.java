import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        System.out.println(names.size());
        names.add("Justin");
        names.add("Helen");
        names.add(1, "Joshua");
        names.add(0,"Laura");

        System.out.println(names);

        names.set(3, "Marie");

        System.out.println(names.get(0));
        System.out.println(names.get(3));

        names.remove("Justin");
        System.out.println(names);

        names.remove(1);
        System.out.println(names);

        names.clear();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);

        System.out.println(numbers);

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(100);
        numbers2.addAll(numbers);

        System.out.println(numbers2);

        System.out.println(numbers.contains(2));
        System.out.println(numbers.contains(4));
        System.out.println(numbers.indexOf(1));
        System.out.println(numbers.lastIndexOf(1));

    }
}
