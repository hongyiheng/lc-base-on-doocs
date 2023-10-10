class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int M = (int)1e9 + 7;
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (long)nums[i];
            arr[i] += s.charAt(i) == 'R' ? d : -d;
        }
        Arrays.sort(arr);
        long b = 0;
        for (int i = 1; i < n; i++) {
            b = (b + arr[i] - arr[0]) % M;
        }
        long ans = b;
        for (int i = 1; i < n; i++) {
            b = (b - (n - i) * (arr[i] - arr[i - 1])) % M;
            ans = (ans + b) % M;
        }
        while (ans < 0) {
            ans += M;
        }
        return (int)(ans % M);
    }
}