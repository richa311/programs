package dataStructures.array;
/* @author Richa Rochna */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountNonRepeatedChar {
    static final int NO_OF_CHARS = 256;
    static HashMap<Character, Integer> hm = new HashMap<>(NO_OF_CHARS);

    public static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                int count = hm.get(str.charAt(i));
                hm.put(str.charAt(i), count + 1);
            } else {
                hm.put(str.charAt(i), 1);
            }
        }
    }

    public static int nonRepeatingCount(String str) {
        getCharCountArray(str);
        int nonrepeated = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int c = entry.getValue();
            if (c == 1) {
                nonrepeated++;
            }
        }
        return nonrepeated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int index = nonRepeatingCount(str);
        System.out.println(index);
    }
}
