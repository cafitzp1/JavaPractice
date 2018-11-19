package my.java.app;

public class App {
    public static void main(String[] args) {

        System.out.println(longestCommonSubstring("abcdaf", "bcdaddd"));
    }

    private static String longestCommonSubstring(String s1, String s2) {

        Integer[][] matrix = new Integer[s1.length() + 1][s2.length() + 2];
        int longest = 0;
        int[] longestXY = new int[] { 0, 0 };

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    int len = matrix[i][j] == null ? 1 : matrix[i][j] + 1;
                    matrix[i + 1][j + 1] = len;
                    if (len > longest) {
                        longest = len;
                        longestXY = new int[] { i + 1, j + 1 };
                    }
                }
            }
        }

        String sr = "";

        for (int i = 0; i < longest; i++) {
            sr = s1.charAt(longestXY[0] - i - 1) + sr;
        }

        return sr;
    }
}