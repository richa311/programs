package streams;
/* @author Richa Rochna */

import dto.Person;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Davis", 60),
                new Person("John", "Smith", 30),
                new Person("Jane", "Smith", 28),
                new Person("Lee", "Cooper", 50)
        );

        people.stream()
                .forEach(person -> System.out.println(person.getFirstName()));

        people.stream()
                .filter(person -> person.getLastName().startsWith("C"))
                .forEach(person -> System.out.println(person.getFirstName()));

        long count = people.stream()
                .filter(person -> person.getLastName().startsWith("C"))
                .count();
        System.out.println(count);

        long parallelCount = people.parallelStream().count();
        System.out.println(parallelCount);

    }
}
