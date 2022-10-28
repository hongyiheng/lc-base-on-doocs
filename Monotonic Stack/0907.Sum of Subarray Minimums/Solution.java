class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] l = new int[n];
        Arrays.fill(l, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) {
                l[q.pollLast()] = i;
            }
            q.addLast(i);
        }
        q.clear();
        int[] r = new int[n];
        Arrays.fill(r, n);
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] > arr[i]) {
                r[q.pollLast()] = i;
            }
            q.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (int)(ans + 1L * (i - l[i]) * (r[i] - i) * arr[i] % mod) % mod;
        }
        return ans;
    }
}
