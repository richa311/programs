package dataStructures.array;

/* @author Richa Rochna */

import java.util.Arrays;
import java.util.Collections;

/*K smallest elements in an array*/
public class KSmallest {

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 23, 12, 9,
                30, 2, 50};
        int k = 5;
        kSmallest(arr, k);
    }

    public static void kSmallest(Integer[] arr, int k) {
        Arrays.sort(arr, Collections.reverseOrder());
        int l = arr.length;
        for (int i = l-1; i >= l-k; i--)
            System.out.print(arr[i] + " ");
    }
}
