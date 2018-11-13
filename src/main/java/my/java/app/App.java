package my.java.app;

import java.util.HashSet;
import java.lang.Character;

public class App {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abvkdkreob"));

    }

    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set;
        int longest = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            j = i;
            set = new HashSet<>();
            char c;
            while (j < s.length()) {
                if (!set.contains(((c = s.charAt(j))))) {
                    set.add(c);
                    j++;
                } else {
                    break;
                }
            }
            if (j-i > longest) longest = j-i;
        }

        return longest;
    }
}