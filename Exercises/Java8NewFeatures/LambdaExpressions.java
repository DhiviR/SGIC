package Java8NewFeatures;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;

public class LambdaExpressions {

    /**
     * Anonymous Classes,
     *      Do not have a name.
     *      are expressions.
     *      consists the following,
     *          new operator
     *          name of an interface
     *          parentheses
     *          body
     *
     *      interface HelloWorld {
     *         public void greet();
     *         public void greetSomeone(String someone);
     *     }
     *
     *      HelloWorld frenchGreeting = new HelloWorld() {
     *             String name = "tout le monde";
     *             public void greet() {
     *                 greetSomeone("tout le monde");
     *             }
     *             public void greetSomeone(String someone) {
     *                 name = someone;
     *                 System.out.println("Salut " + name);
     *             }
     *         };
     */

    /**
     *
     */

    public class Person {
        String name;
        LocalDate birthday;
        String emailAddress;

        public int getAge() {
            //...
            return 0;
        }

        public void printPerson() {
            System.out.println("Person");
        }
    }

//    Search method for persons that match the condition
    public static void PrintPersonsOlderThan(List<Person> list, int age) {
        for (Person p : list) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

//    Generalized search method (Specifying search conditions in a class)
    public static void printPersons(List<Person> list, CheckPerson tester) {
        for (Person p : list) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }
    interface CheckPerson {
        boolean test(Person p);
    }

    class CheckPersonEligibleCondition implements CheckPerson {
        public boolean test(Person p) {
            return p.getAge() >= 18 && p.getAge() <= 25;
        }
    }
}
