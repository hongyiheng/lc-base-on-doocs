class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] hGroup = new ArrayList[101];
        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1];
            if (hGroup[y] == null) {
                hGroup[y] = new ArrayList<>();
            }
            hGroup[y].add(x);
        }
        for (var g : hGroup) {
            if (g != null) {
                Collections.sort(g);
            }
        }
        int n = points.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            for (int h = y; h < 101; h++) {
                if (hGroup[h] == null) {
                    continue;
                }
                int l = 0, r = hGroup[h].size() - 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (hGroup[h].get(mid) < x) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (hGroup[h].get(l) >= x) {
                    ans[i] += hGroup[h].size() - l;
                }
            }
        }
        return ans;
    }
}
