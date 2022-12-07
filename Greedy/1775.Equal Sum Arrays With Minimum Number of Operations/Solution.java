class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m * 6 || n * 6 < m) {
            return -1;
        }
        int t = 0;
        for (int v : nums1) {
            t += v;
        }
        for (int v : nums2) {
            t -= v;
        }
        if (t < 0) {
            t = -t;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums1) {
            mp.put(v - 1, mp.getOrDefault(v - 1, 0) + 1);
        }
        for (int v : nums2) {
            mp.put(6 - v, mp.getOrDefault(6 - v, 0) + 1);
        }
        int ans = 0;
        for (int i = 5; i >= 1; i--) {
            if (t <= 0) {
                break;
            }
            int num = mp.getOrDefault(i, 0);
            if (num * i >= t) {
                ans += (t + i - 1) / i;
            } else {
                ans += num;
            }
            t -= num * i;
        }
        return ans;
    }
}
