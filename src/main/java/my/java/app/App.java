package my.java.app;

public class App {

    // create a function to increment surrounding fields in a game of mine sweeper
    // when the bomb locations are known. for example, bombs at [0,0] and [0,1] mean
    // the surrounding fields should look like this...

    // -1 -1  1  0 
    //  2  2  1  0 
    //  0  0  0  0 

    public static void main(String[] args) {

        int[][] bombs = new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 } };
        int[][] results = mineSweeper(bombs, 3, 4);

        for (int[] result : results) {
            for (int num : result) {
                if (num != -1)
                    System.out.print(" ");
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mineSweeper(int[][] bombs, int rows, int cols) {

        int[][] result = new int[rows][cols];


        // initialize result field
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
            }
        }

        // add bombs
        for (int[] bomb : bombs) {
            result[bomb[0]][bomb[1]] = -1;
        }

        // increment for bombs
        for (int[] bomb : bombs) {
            addAround(result, bomb);
        }

        return result;
    }

    private static void addAround(int[][] input, int[] loc) {
        int x = loc[0], y = loc[1];

        // check for row before, row of, and row after
        for (int i = -1; i < 2; i++) {

            // check col before, col of, and col after
            for (int j = -1; j < 2; j++) {
                if (x + i >= 0 && x + i < input.length && y + j >= 0 && y + j < input[0].length)
                    if (input[x + i][y + j] >= 0)
                        input[x + i][y + j] += 1;
            }
        }
    }
}