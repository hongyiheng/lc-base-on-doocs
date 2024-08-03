class Solution {

    List<int[]> q = new ArrayList<>();
    Set<Character> vis = new HashSet<>();

    public int f(int i, int d, String s) {
        int ans = 0;
        while (i < q.size()) {
            int x = q.get(i)[0], y = q.get(i)[1], j = q.get(i)[2];
            if (x > d || y > d) {
                break;
            }
            if (vis.contains(s.charAt(j))) {
                return -1;
            }
            vis.add(s.charAt(j));
            ans++;
            i++;
        }
        return ans;
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            q.add(new int[]{Math.abs(p[0]), Math.abs(p[1]), i});
        }
        Collections.sort(q, Comparator.comparingInt(a -> Math.max(a[0], a[1])));
        int i = 0;
        while (i < q.size()) {
            int x = q.get(i)[0], y = q.get(i)[1];
            int cnt = f(i, Math.max(x, y), s);
            if (cnt == -1) {
                break;
            }
            i += cnt;
        }
        return i;
    }
}