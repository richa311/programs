package lambdas;
/* @author Richa Rochna */

import java.util.function.BiConsumer;

public class ExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int key = 0;
        process(numbers, key, (v, k) -> {
            try {
                System.out.println(v / k);
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception Occurred");
            }
        });
    }

    private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : numbers) {
            consumer.accept(i, key);
        }
    }
}
