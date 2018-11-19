package my.java.app;

public class App {
    public static void main(String[] args) {

        System.out.println(longestPalindromicSubstring("babad"));
        System.out.println(longestPalindromicSubstring("cbbd"));
        System.out.println(longestPalindromicSubstring("abcba"));
    }

    private static String longestPalindromicSubstring(String s) {
        if (s == null || s == "")
            return null;

        int start = 0, end = 0;

        for (int i = 0, len = 0; i < s.length(); i++) {
            len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}