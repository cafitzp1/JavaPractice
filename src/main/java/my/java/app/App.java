package my.java.app;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println((nonRepeating("abcab"))); // should return 'c'
        System.out.println((nonRepeating("abab"))); // should return null
        System.out.println((nonRepeating("aabbbc"))); // should return 'c'
        System.out.println((nonRepeating("aabbdbc"))); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {

        if ( s == null || s.length()==0)
            return null;

        Character firstChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (firstChar == s.charAt(i)) {
                return nonRepeating(s.replace(firstChar.toString(), ""));
            }
        }

        return firstChar;
    }
}