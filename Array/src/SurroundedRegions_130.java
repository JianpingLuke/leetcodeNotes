public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) dfs(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) { // 从边界的0开始，非常智慧的解法
        if (i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || board[i][j]!='O') return;
        board[i][j] = '-';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}// 正向解决不了的问题，要学会逆向思维
