package lambdas;
/* @author Richa Rochna */

import dto.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterface {
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
        performConditionally(people, p -> true, p -> System.out.println(p));

        //Create a method that prints all people that have last name and first name beginning with C
        System.out.println("Prints all people that have last name beginning with C");
        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        System.out.println("Prints all people that have first name beginning with C");
        performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));

        System.out.println("Prints all first name beginning with C");
        performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
    }

    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p))
                consumer.accept(p);
        }
    }
}
