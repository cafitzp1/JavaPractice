package my.java.app;

public class App {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        if (string == null || string.length() == 0)
            return false;

        string = string.toLowerCase();
        LinkedQueue<Character> ordered = new LinkedQueue<>();
        LinkedStack<Character> reversed = new LinkedStack<>();
        int length = 0;

        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (current >= 'a' && current <= 'z') {
                length++;
                ordered.add(current);
                reversed.push(current);
            }
        }

        while(length > 0) {
            if (ordered.remove() != reversed.pop())
                return false;

            length--;
        }
        return true;
    }
}