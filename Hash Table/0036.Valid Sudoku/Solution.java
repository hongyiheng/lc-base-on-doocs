class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>(), col = new HashMap<>(), box = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char v = board[i][j];
                if (v == '.') {
                    continue;
                }
                Set<Character> r = row.getOrDefault(i, new HashSet<>());
                Set<Character> c = col.getOrDefault(j, new HashSet<>());
                Set<Character> b = box.getOrDefault(i / 3 * 3 + j / 3, new HashSet<>());
                if (r.contains(v) || c.contains(v) || b.contains(v)) {
                    return false;
                }
                r.add(v);
                c.add(v);
                b.add(v);
                row.put(i, r);
                col.put(j, c);
                box.put(i / 3 * 3 + j / 3, b);
            }
        }
        return true;
    }
}