package edu.sjsu.assignment1;

public class Matrix {
    private final int[][] matrix; // Matrix is immutable
    private final int size;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix multiply(Matrix givenMatrix) {
        int[][] newMatrix = givenMatrix.getMatrix();
        int[][] finalMatrix = new int[this.matrix.length][newMatrix[0].length];

        for (int row = 0; row < finalMatrix.length; row++) {

            for (int column = 0; column < finalMatrix[row].length; column++) {
                int value = 0;
                for (int i = 0; i < newMatrix.length; i++) {
                    value += this.matrix[row][i] * newMatrix[i][column];
                }
                finalMatrix[row][column] = value;
            }

        }

        return new Matrix(finalMatrix);
    }
}
