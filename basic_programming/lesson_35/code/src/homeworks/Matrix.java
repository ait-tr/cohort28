package ait.matrix.utils;

public class Matrix {
    public static int sum(int[][] matrix){
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res += matrix[i][j];
            }
        }
        return res;
    }

    public static int[][] transp(int[][] matrix){
        int[][] res = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2){
        if (matrix1[0].length != matrix2.length) {
            return null;
        }
        int[][] res = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = getCell(matrix1, matrix2, i, j);
            }
        }

        return res;
    }
    private static int getCell(int[][] matrix1, int[][] matrix2, int i, int j) {
        int sum = 0;
        for (int k = 0; k < matrix2.length; k++) {
            sum += matrix1[i][k] * matrix2[k][j];
        }
        return sum;
    }
}
