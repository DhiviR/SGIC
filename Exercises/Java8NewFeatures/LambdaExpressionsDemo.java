package Java8NewFeatures;

import java.util.List;

import Java8NewFeatures.LambdaExpressions.CheckPerson;
import Java8NewFeatures.LambdaExpressions.Person;

public class LambdaExpressionsDemo {
    public static void main(String[] args) {
        List<Person> list = null;

//    Generalized search method using Anonymous class
        LambdaExpressions.printPersons(
                list,
                new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getAge() >= 18 && p.getAge() <= 25;
                    }
                }
        );

//        Search method using lambda expressions

        LambdaExpressions.printPersons(
                list,
                (Person p) -> {
                    return p.getAge() >= 18 && p.getAge() <= 25;
                }
        );
    }
}
