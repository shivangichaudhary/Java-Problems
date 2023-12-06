public class fibonacciNumbers {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] resultMatrix1 = new int[3][3]; // Create a matrix to store the result
        int[][] resultMatrix2 = new int[3][3];
        // Perform matrix addition
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultMatrix1[i][j] = matrix1[i][j] + matrix2[i][j];
                resultMatrix2[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }

        // Display the result matrix
        System.out.println("Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Matrix 2:");
        printMatrix(matrix2);

        System.out.println("Matrix Addition Result:");
        printMatrix(resultMatrix1);

        System.out.println("Matrix Multiplication Result:");
        printMatrix(resultMatrix2);
    }

    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
