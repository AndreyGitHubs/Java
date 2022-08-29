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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("------------------------------\n");
        for (int i = 0; i < size; i++) {
            result.append("|");
            for (int j = 0; j < size; j++) {
                result.append((board[i][j] ? "X" : " ") + "|");
            }
            result.append("\n");
        }
        result.append("------------------------------");
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
}
