// File: logic/TicTacToe.java
package logic;

public class TicTacToe {
    private final String player1;
    private final String player2;
    private String currentPlayer;
    private String[][] board = new String[3][3];

    public TicTacToe(String p1, String p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;

        // Initialize the board with empty strings
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = "";
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col].equals("")) {
            board[row][col] = getCurrentPlayerSymbol();
            return true;
        }
        return false;
    }

    public String getCurrentPlayerSymbol() {
        return currentPlayer.equals(player1) ? "X" : "O";
    }

    public String getCurrentPlayerName() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }

    public boolean isBoardFull() {
        for (String[] row : board)
            for (String cell : row)
                if (cell.equals("")) return false;
        return true;
    }

    public boolean checkWin() {
        String sym = getCurrentPlayerSymbol();

        // Rows, Columns, Diagonals
        for (int i = 0; i < 3; i++) {
            if (sym.equals(board[i][0]) && sym.equals(board[i][1]) && sym.equals(board[i][2])) return true;
            if (sym.equals(board[0][i]) && sym.equals(board[1][i]) && sym.equals(board[2][i])) return true;
        }
        return (sym.equals(board[0][0]) && sym.equals(board[1][1]) && sym.equals(board[2][2])) ||
                (sym.equals(board[0][2]) && sym.equals(board[1][1]) && sym.equals(board[2][0]));
    }
}

