import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '.';
            }
        }
        solve(arr, 0, ans);
        return ans;
    }
    public void solve(char[][] arr, int row, List<List<String>> ans) {
        if (row == arr.length) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                board.add(new String(arr[i]));
            }
            ans.add(board);
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if (toCheck(arr, row, col)) {
                arr[row][col] = 'Q';
                solve(arr, row + 1, ans);
                arr[row][col] = '.';
            }
        }
    }
    public boolean toCheck(char[][] arr, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
