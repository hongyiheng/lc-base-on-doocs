class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] ps = new int[][]{p1, p2, p3, p4};
        Map<Integer, Integer> mp = new HashMap<>();
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int dist = getDist(ps[i], ps[j]);
                l = Math.min(l, dist);
                mp.put(dist, mp.getOrDefault(dist, 0) + 1);
            }
        }
        return mp.size() == 2 && mp.get(l) == 4;
    }

    public int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
