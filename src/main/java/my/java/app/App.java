package my.java.app;

import java.util.HashSet;
import java.lang.Character;

public class App {
    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[] { "aaa", "aa", "aaa"} ));

    }

    public static String longestCommonPrefix(String[] strs) {

        // return if string empty
        if (strs == null || strs.length == 0) return "";

        // return if string within array is empty
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0)
                return "";
        }

        // return if no common prefix
        HashSet<Character> set;
        String prefix = "";
        char current = '\0';
        int length = strs[0].length();
        int shortestLength = length;

        // char iteration
        int i = 0;
        while (i < length) {

            set = new HashSet<>();
            // array iteration
            for (int j = 0; j < strs.length; j++) {
                if (i == 0) {
                    if ((shortestLength = strs[j].length()) < length)
                        length = shortestLength;
                }
                if (j == 0) {
                    current = strs[0].charAt(i);
                }

                set.add(strs[j].charAt(i));
            }
            if (set.size() > 1) {
                return prefix;
            } else {
                prefix += current; 
            }

            i++;
        }

        return prefix;
    }
}