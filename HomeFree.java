
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

public class HomeFree {
    public static void main(String[] args) {
        List<QueenBoard> solutions = new NQueensProblem(5).getAllSolutions();
        for (QueenBoard board : solutions) {
            System.out.println(board.toString());
        }
    }
}

class NQueensProblem {

    private List<QueenBoard> solutions;

    public NQueensProblem(int size) {
        this.solutions = new LinkedList<QueenBoard>();
        solve(size);
    }

    public void solve(int size) {
        QueenBoard board = new QueenBoard(size);
        LogicalBoard logicalBoard = new LogicalBoard(size);
        solve(board, logicalBoard, 0, size);
    }

    public List<QueenBoard> getAllSolutions() {
        return solutions;
    }

    private void solve(QueenBoard board, LogicalBoard logicalBoard,
            int rowNumber, int size) {
        if (rowNumber == size) {
            solutions.add(board);
            return;
        }
        for (int column = 0; column < size; column++) {
            if (logicalBoard.getPossible(rowNumber, column)) {
                QueenBoard newBoard = new QueenBoard(board);
                newBoard.setHasQueen(rowNumber, column, true);
                LogicalBoard newLogicalBoard = new LogicalBoard(logicalBoard);
                newLogicalBoard.setPossible(rowNumber, column, false);
                updateBoard(rowNumber, column, newLogicalBoard, size);
                solve(newBoard, newLogicalBoard, rowNumber + 1, size);
            }
        }
    }

    private void updateBoard(int row, int col, LogicalBoard logicalBoard, int size) {
        for (int j = 0; j < size; j++) {
            logicalBoard.setPossible(row, j, false);
        }
        for (int j = 0; j < size; j++) {
            logicalBoard.setPossible(j, col, false);
        }
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            logicalBoard.setPossible(r, c, false);
            r--;
            c--;
        }
        r = row;
        c = col;
        while (r < 5 && c < 5) {
            logicalBoard.setPossible(r, c, false);
            r++;
            c++;
        }
        r = row;
        c = col;
        while (r < 5 && c >= 0) {
            logicalBoard.setPossible(r, c, false);
            r++;
            c--;
        }
        r = row;
        c = col;
        while (r >= 0 && c < 5) {
            logicalBoard.setPossible(r, c, false);
            r--;
            c++;
        }
    }
}

class QueenBoard {
    private boolean[][] board;
    int size;

    public QueenBoard(int size) {
        this.size = size;
        this.board = new boolean[size][size];
    }

    public QueenBoard(QueenBoard oldBoard) {
        this.size = oldBoard.size;
        this.board = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = oldBoard.board[i][j];
            }
        }
    }

    public void setHasQueen(int x, int y, boolean value) {
        board[x][y] = value;
    }

    public boolean hasQueen(int x, int y) {
        return board[x][y];
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append("|");
            for (int j = 0; j < size; j++) {
                result.append((board[i][j] ? "X" : " ") + "|");
            }
            result.append("\n");
        }
        return result.toString();
    }
}

class LogicalBoard {

    private boolean[][] board;
    int size;

    public LogicalBoard(int size) {
        this.size = size;
        board = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = true;
            }
        }
    }

    public LogicalBoard(LogicalBoard oldBoard) {
        this.size = oldBoard.size;
        this.board = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = oldBoard.board[i][j];
            }
        }
    }

    public void setPossible(int x, int y, boolean value) {
        board[x][y] = value;
    }

    public boolean getPossible(int x, int y) {
        return board[x][y];
    }

    // public class NQueen {
    // List<List<String>> ans = new ArrayList<>();
    // char[][] board;

    // public static void main(String[] args) {
    // NQueen sol = new NQueen();
    // sol.solveNQueens(5);

    // System.out.println(sol.ans.size());
    // for (var board : sol.ans) {
    // board.forEach(System.out::println);
    // System.out.println("---");
    // }
    // }

    // public List<List<String>> solveNQueens(int n) {
    // init(n);

    // backtrack(0, n);
    // return ans;
    // }

    // boolean backtrack(int col, int n) {
    // if (col == n) {
    // addBoard();
    // return true;
    // }
    // for (int row = 0; row < n; row++) {
    // if (isSafe(row, col)) {
    // board[row][col] = 'Q';
    // backtrack[col + 1, n];
    // board[row][col] = '.';

    // }
    // }
    // return false;
    // }

    // boolean isSafe(int row, int col) {
    // for (int i = 0; i < col; i++) {
    // if (board[row][i] == 'Q') return false;
    // }
    // for (int i = row - 1 ; j = col - 1; i >= 0 && j >= 0; i--, j--){
    // if (board[i][j] == 'Q') return false;
    // }
    // for (int i = row + 1 ; j = col - 1; i < board.length && j >= 0; i++, j--){
    // if (board[i][j] == 'Q') return false;
    // }
    // return true;
    // }

    // private void addBoard() {
    // List<String> newBoard = new ArrayList<>();

    // for (char[] chars : board) {
    // newBoard.add(new String(chars));
    // }
    // ans.add(newBoard);
    // }

    // private void init(int n) {
    // board = new char[n][n];

    // for (int i = 0; i < n; i++) {
    // char[] row = new char[n];
    // for (int j = 0; j < n; j++) {
    // row[j] = '.';
    // }
    // board[i] = row;
    // }
    // }
    // }
}
