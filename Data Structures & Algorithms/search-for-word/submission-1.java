class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(dfs(board, word, 0, r, c)) return true;

            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int r, int c){
        if(index == word.length()) return true;

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean bottom = dfs(board, word, index + 1, r + 1, c);
        boolean top = dfs(board, word, index + 1, r - 1, c);
        boolean right = dfs(board, word, index + 1, r, c + 1);
        boolean left = dfs(board, word, index + 1, r, c - 1);

        board[r][c] = temp;
        if(bottom || top || right || left) return true;

        return false;
    }
}
