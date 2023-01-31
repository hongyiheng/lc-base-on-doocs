class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> s = new HashSet<>();
        for (int[] c : circles) {
            int x = c[0], y = c[1], r = c[2];
            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    if (1L * (i - x) * (i - x) + 1L * (j - y) * (j - y) <= 1L * r * r) {
                        s.add(i + "," + j);
                    }
                }
            }
        }
        return s.size();
    }
}
