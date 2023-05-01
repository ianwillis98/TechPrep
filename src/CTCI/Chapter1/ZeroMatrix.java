package CTCI.Chapter1;

/*
1.8 Zero Matrix
Write an algorithm such that if an element in an M x N matrix is 0,
its entire row and column are set to 0
 */
public class ZeroMatrix {

    public static void zero(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            if (zeroRows[row]) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            if (zeroCols[col]) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void zeroNoExtraMem(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // Check if first row has a zero
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // Check for zeros in the rest of the array
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (rowHasZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        if (colHasZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    private static void print(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 3, 4, 0},
                {5, 6, 7, 8, 1},
                {9, 0, 11, 12, 1},
                {13, 14, 15, 16, 1}
        };

        print(matrix);
        zeroNoExtraMem(matrix);
        System.out.println();
        print(matrix);
    }
}
