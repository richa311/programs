package dataStructures.array;
/* @author Richa Rochna */

import java.util.Arrays;
import java.util.Objects;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
        int l = arr.length;

        int[] triplet = pythagoreanTriplet(arr, l);

        if (Objects.nonNull(triplet)) {
            System.out.println("True");
            System.out.println("There is a Pythagorean triplet");
            Arrays.stream(triplet).forEach(
                    System.out::println);
        } else {
            System.out.println("False");
            System.out.println("There is no Pythagorean triplet");
        }

    }

    private static int[] pythagoreanTriplet(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x = arr[i] * arr[i];
                    int y = arr[j] * arr[j];
                    int z = arr[k] * arr[k];
                    if (x == y + z || y == x + z || z == x + y) {
                        return new int[]{arr[i], arr[j], arr[k]};
                    }
                }
            }
        }
        return null;
    }
}
