package my.java.app;

public class App {
    public static void main(String[] args) {

        System.out.println(hash("hello")%10);
        System.out.println(hash("good-bye")%10);
        
    }

    private static int hash(String key) {

        char[] keyChars = key.toCharArray();
        int hashedKey = 0;

        for (char c : keyChars)
            hashedKey += c;
        hashedKey %= 2069;

        return hashedKey;
    }
}