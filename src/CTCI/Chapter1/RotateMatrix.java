package CTCI.Chapter1;

import java.util.Arrays;

/*
1.7 Rotate Matrix
Given an image represented by an N x N matrix, where each pixel in
the image is represented by an integer, write a method to rotate the image by 90
degrees. Can you do this in place?
 */
public class RotateMatrix {

    public static int[][] rotateNewMatrix(int[][] matrix) {
        // x, y --> (height - y - 1), x
        // row, col --> col, (height - row - 1)
        int[][] rotated = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int newRow = col;
                int newCol = matrix.length - row - 1;
                rotated[newRow][newCol] = matrix[row][col];
            }
        }

        return rotated;
    }

    public static void rotateInPlace(int[][] matrix) {
        // x, y --> (height - y - 1), x
        // row, col --> col, (height - row - 1)
        for (int row = 0; row < matrix.length / 2; row++) {
            for (int col = row; col < (matrix[0].length - 1) - row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[(matrix.length - 1) - col][row];
                matrix[(matrix.length - 1) - col][row] = matrix[(matrix.length - 1) - row][(matrix.length - 1) - col];
                matrix[(matrix.length - 1) - row][(matrix.length - 1) - col] = matrix[col][(matrix.length - 1) - row];
                matrix[col][(matrix.length - 1) - row] = temp;
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
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        print(matrix);

        int[][] rotated = rotateNewMatrix(matrix);
        System.out.println();

        print(rotated);

        System.out.println();
        print(matrix);
        rotateInPlace(matrix);
        System.out.println();
        print(matrix);
    }
}
