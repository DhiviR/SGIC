package Java8NewFeatures;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImprovedTypeInference {

    /**
     * Type inference is a Java compiler's ability to determine the type of the arguments by looking at the method
     * invocation and corresponding declaration.
     */

    public static void main(String[] args) {
//        Won't work in Java 7
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.addAll(Arrays.asList());

//        Works in Java 7
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("A");
        stringList2.addAll(Arrays.<String>asList());
    }
}
