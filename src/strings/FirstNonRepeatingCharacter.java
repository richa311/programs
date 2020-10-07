package strings;
/* @author Richa Rochna */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        String stream = scanner.next();
        stream = stream.replaceAll("\\s", "");

        for(int i = 0; i<t; i++){
            findFirstNonRepeating(stream);
        }
    }

    final static int MAX_CHAR = 256;

    static void findFirstNonRepeating(String stream)
    {
        // inDLL[x] contains pointer to a DLL node if x is present
        // in DLL. If x is not present, then inDLL[x] is NULL
        List<Character> inDLL = new ArrayList<>();

        // repeated[x] is true if x is repeated two or more times.
        // If x is not seen so far or x is seen only once. then
        // repeated[x] is false
        boolean[] repeated = new boolean[MAX_CHAR];

        for (int i = 0; i < stream.length(); i++) {
            char x = stream.charAt(i);

            // We process this character only if it has not occurred
            // or occurred only once. repeated[x] is true if x is
            // repeated twice or more.s
            if (!repeated[x]) {
                // If the character is not in DLL, then add this at
                // the end of DLL.
                if (!(inDLL.contains(x))) {
                    inDLL.add(x);
                }
                else // Otherwise remove this character from DLL
                {
                    inDLL.remove((Character)x);
                    repeated[x] = true; // Also mark it as repeated
                }
            }

            // Print the current first non-repeating character from
            // stream
            if (inDLL.size() != 0) {
                System.out.print(inDLL.get(0) + " ");
            } else {
                System.out.print("-1 ");
            }
        }
    }
}
