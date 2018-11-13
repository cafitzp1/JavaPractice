package my.java.app;

public class App {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));

    }

    public static int romanToInt(String s) {

        int index = 0;
        char prev = '\0';
        char current = '\0';
        int num = 0;

        while (index < s.length()) {
            current = s.charAt(index);

            switch (current) {
                case 'I':
                    num += 1;
                break;
                case 'V':
                    if (prev == 'I')
                        num -= 2;
                    num += 5;
                break;
                case 'X':
                    if (prev == 'I')
                        num -= 2;
                    num += 10;
                break;
                case 'L':
                    if (prev == 'X')
                        num -= 20;
                    num += 50;
                break;
                case 'C':
                    if (prev == 'X')
                        num -= 20;
                    num += 100;
                break;
                case 'D':
                    if (prev == 'C')
                        num -= 200;
                    num += 500;
                break;
                case 'M':
                    if (prev == 'C')
                        num -= 200;
                    num += 1000;
                break;
            }

            prev = current;
            index++;
        }

        return num;
    }
}