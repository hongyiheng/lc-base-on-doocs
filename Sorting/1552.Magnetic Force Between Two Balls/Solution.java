class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0, r = position[position.length - 1];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(position, mid, m)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
    }

    public boolean check(int[] position, int x, int m) {
        int last = position[0], ans = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= x) {
                last = position[i];
                ans++;
            }
        }
        return ans >= m;
    }
}