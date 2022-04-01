class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n = 100010;
        int m = 2 * n;
        int[] cnt = new int[m * 2];
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));
        for (int num : arr) {
            if (++cnt[num + n] == 1) {
                q.add(num);
            }
        }
        while (!q.isEmpty()) {
            int idx = q.poll();
            if (cnt[idx + n] > cnt[idx * 2 + n]) {
                return false;
            }
            cnt[idx * 2 + n] -= cnt[idx + n];
        }
        return true;
    }
}