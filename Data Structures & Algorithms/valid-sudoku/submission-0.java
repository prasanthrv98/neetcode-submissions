class Solution {
    public boolean isValidSudoku(char[][] board) {
        int boardLen = board[0].length;
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for(int r = 0; r < boardLen; r++){
            for(int c = 0; c < boardLen; c++){

                char currentChar = board[r][c];
                if(currentChar == '.') continue;

                String squareKey = (r / 3) + " " + (c / 3); 

                if(row.computeIfAbsent(r, k -> new HashSet<>()).contains(currentChar)
                  || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(currentChar)
                  || boxes.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(currentChar)
                  )
                  {
                    return false;
                  }

                  row.get(r).add(currentChar);
                  cols.get(c).add(currentChar);
                  boxes.get(squareKey).add(currentChar);
            }
        }

        return true;
    }
}


