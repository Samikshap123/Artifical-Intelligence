import java.util.*;

public class NQueenProblem {
    private static final int N = 8; // Size of the chessboard

    // Function to solve the N-Queen problem
    private static void solveNQueen() {
        int[][] board = new int[N][N];
        if (!solveNQueenUtil(board, 0)) {
            System.out.println("No solution exists.");
        }
    }

    // Recursive function to solve the N-Queen problem
    private static boolean solveNQueenUtil(int[][] board, int col) {
        // Base case: If all queens are placed, return true
        if (col >= N) {
            return true;
        }

        // Check each row in the current column
        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                // Place the queen on the board
                board[row][col] = 1;

                // Recur to place queens in the next columns
                if (solveNQueenUtil(board, col + 1)) {
                    return true;
                }

                // If placing the queen doesn't lead to a solution,
                // backtrack and remove the queen from the board
                board[row][col] = 0;
            }
        }

        // If no row is safe in the current column, return false
        return false;
    }

    // Function to check if a queen can be placed safely at the given position
    private static boolean isSafe(int[][] board, int row, int col) {
        // Check if there is a queen in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // The position is safe
        return true;
    }

    // Function to print the chessboard
    private static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveNQueen();
    }
}

Output:
Enter number of vertices and edges
5
6
Enter the edges
0
1
0
2
2
3
3
4
2
4
1
4
Enter source for bfs traversal

2
2
0
3
4
1
