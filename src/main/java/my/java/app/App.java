package my.java.app;

import java.lang.Character;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome1("abccba"));
        // should return true
        System.out.println(checkForPalindrome1("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome1("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome1("hello"));
        // should return true
        System.out.println(checkForPalindrome1("Don't nod"));
    }

    // udemy solution
    public static boolean checkForPalindrome1(String string) {

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedString = new StringBuilder(stack.size());
        while(!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return stringNoPunctuation.toString().equals(reversedString.toString()) ? true : false;
    }

    // my solution
    public static boolean checkForPalindrome2(String string) {

        LinkedList<Character> stack = new LinkedList<>();
        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            char current;
            if(Character.isLetter((current = string.charAt(i))))
                stack.push(current);
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i))) 
                continue;
            if (stack.pop() != string.charAt(i))
                return false;
        }

        return true;
    }
}
