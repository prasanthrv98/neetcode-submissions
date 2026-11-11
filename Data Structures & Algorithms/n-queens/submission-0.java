class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i],'.');
        }

        dfs(board, 0, res);

        return res;

    }

    void dfs(char[][] board, int row, List<List<String>> res){
        int n = board.length;

        if(row == n){
            List<String> snapshot = new ArrayList<>();

            for(int i = 0; i < n; i++){
                snapshot.add(new String(board[i]));
            }
            res.add(snapshot);
            return;
        }

        for(int col = 0; col < n; col++){

            if(!isSafe(board, row, col)) continue;

            board[row][col] = 'Q';

            dfs(board, row + 1, res);

            board[row][col] = '.';
        }


    }

    boolean isSafe(char[][] board, int row, int col){


        for(int r = row - 1; r >= 0; r--){
            if(board[r][col] == 'Q') return false;
            
        }

        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--){
            if(board[r][c] == 'Q') return false;
            
        }

        for(int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++){
            if(board[r][c] == 'Q') return false;
            
        }


        return true;
    }
}
