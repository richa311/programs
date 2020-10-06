package lambdas;
/* @author Richa Rochna */

import dto.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSolution {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Davis", 60),
                new Person("John", "Smith", 30),
                new Person("Jane", "Smith", 28),
                new Person("Lee", "Cooper", 50)
        );

        //Sort List by Last Name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        //Create a method that prints all elements in the list
        System.out.println("Prints all people");
        printConditionally(people, p -> true);

        //Create a method that prints all people that have last name and first name beginning with C

        System.out.println("Prints all people that have last name beginning with C");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("Prints all people that have first name beginning with C");
        printConditionally(people, p -> p.getFirstName().startsWith("C"));
    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person p : people) {
            if (condition.test(p))
                System.out.println(p);
        }
    }

    interface Condition {
        boolean test(Person p);
    }
}
