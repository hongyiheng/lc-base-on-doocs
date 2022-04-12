class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int row = 1, residue = 0;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (residue + w > 100) {
                row++;
                residue = w;
            } else {
                residue += w;
            }
        }
        return new int[]{row, residue};
    }
}