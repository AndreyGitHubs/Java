import java.util.Arrays;

// Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке
// была строго один раз.

public class HomeFreeTwo {

    static int path = 0;
    static int[][] steps = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 }, };
    static int size = 5;

    public static void main(String[] args) {

        int[][] chessBoard = new int[size][size];
        int rowStart = 2;
        int colStart = 2;
        chessBoard[rowStart][colStart] = 1;

        solveHorse(chessBoard, rowStart, colStart, 1);
    }

    public static boolean solveHorse(int[][] board, int row, int col, int numberStep) {

        if (numberStep == size * size) {
            printBoard(board);
            return false;
        }
        for (int i = 0; i < steps.length; i++) {
            int newRow = row + steps[i][0];
            int newCol = col + steps[i][1];

            int newStep = numberStep + 1;
            if (isValid(board, newRow, newCol)) {
                board[newRow][newCol] = newStep;
                if (solveHorse(board, newRow, newCol, newStep)) {
                    return true;
                } else {
                    board[newRow][newCol] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col) {
        if (row >= size || row < 0)
            return false;
        if (col >= size || col < 0)
            return false;
        if (board[row][col] != 0)
            return false;

        return true;
    }

    public static void printBoard(int[][] arr) {
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();
    }
}