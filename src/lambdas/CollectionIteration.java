package lambdas;
/* @author Richa Rochna */

import dto.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIteration {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Davis", 60),
                new Person("John", "Smith", 30),
                new Person("Jane", "Smith", 28),
                new Person("Lee", "Cooper", 50)
        );

        System.out.println("Using for in loop");
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("Using lambda for each loop");
        people.forEach(System.out::println);

    }
}
