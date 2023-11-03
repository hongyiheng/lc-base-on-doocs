class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = 0, s = 0;
        List<int[]> q = new ArrayList<>();
        while (r < n) {
            s += arr[r];
            while (s > target) {
                s -= arr[l++];
            }
            if (s == target) {
                q.add(new int[]{r - l + 1, l, r});
            }
            r++;
        }
        Collections.sort(q, (a, b) -> a[0] - b[0]);
        int m = q.size(), ans = n + 1;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (q.get(i)[0] + q.get(j)[0] >= ans) {
                    break;
                }
                if (q.get(i)[1] > q.get(j)[2] || q.get(j)[1] > q.get(i)[2]) {
                    ans = q.get(i)[0] + q.get(j)[0];
                }
            }
        }
        return ans > n ? -1 : ans;
    }
}