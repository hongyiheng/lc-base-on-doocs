class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0;
        int right = (position[position.length - 1] - position[0]) / (m - 1);
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(position, mid, m)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] position, int x, int m) {
        int last = position[0];
        m--;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= x) {
                last = position[i];
                m--;
            }
        }
        return m <= 0;
    }
}