class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] cnt = new int[10];
        for (int v : nums1) {
            cnt[v] = 1;
        }
        for (int v : nums2) {
            cnt[v] = cnt[v] == 1 ? 3 : 2;
        }
        int a = 0, b = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt[i] == 3) {
                return i;
            }
            if (cnt[i] == 1 && a == 0) {
                a = i;
            }
            if (cnt[i] == 2 && b == 0) {
                b = i;
            }
        }
        return Math.min(a, b) * 10 + Math.max(a, b);
    }
}