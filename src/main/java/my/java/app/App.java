package my.java.app;

public class App {
    public static void main(String[] args) {

        System.out.println("Hi there");

    }

    private static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value)
                return i;
        }
        return -1;
    }
}