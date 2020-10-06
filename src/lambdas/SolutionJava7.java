package lambdas;
/* @author Richa Rochna */

import dto.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SolutionJava7 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Davis", 60),
                new Person("John", "Smith", 30),
                new Person("Jane", "Smith", 28),
                new Person("Lee", "Cooper", 60)
        );

        //Sort List by Last Name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        //Create a method that prints all elements in the list
        System.out.println("Prints all people");
        printAll(people);

        //Create a method that prints all people that have last name beginning with C
        personLastNameBeginningWithC(people);

        System.out.println("Prints all people that have last name beginning with C");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("C");
            }
        });

        System.out.println("Prints all people that have first name beginning with C");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("C");
            }
        });
    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person p: people) {
            if(condition.test(p))
                System.out.println(p);
        }
    }

    private static void personLastNameBeginningWithC(List<Person> people) {
        for (Person p: people) {
            if(p.getLastName().startsWith("C"))
                System.out.println(p);
        }
    }

    private static void printAll(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }

    interface Condition{
        boolean test(Person p);
    }
}
