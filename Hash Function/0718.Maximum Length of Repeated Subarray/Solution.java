class Solution {

    long base = 113, mod = (int)1e9 + 7;

    public int findLength(int[] nums1, int[] nums2) {
        int left = 0, right = Math.min(nums1.length, nums2.length);
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(nums1, nums2, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums1, int[] nums2, int k) {
        Set<Long> a = getHashSet(nums1, k);
        Set<Long> b = getHashSet(nums2, k);
        a.retainAll(b);
        return !a.isEmpty();
    }

    public Set<Long> getHashSet(int[] path, int k) {
        long h = 0;
        for (int i = 0; i < k; i++) {
            h = (h * base + path[i]) % mod;
        }
        Set<Long> ans = new HashSet<>();
        ans.add(h);
        long mult = 1;
        for (int i = 0; i < k; i++) {
            mult = mult * base % mod;
        }
        for (int i = k; i < path.length; i++) {
            h = ((h * base - path[i - k] * mult) % mod + mod) % mod;
            h = (h + path[i]) % mod;
            ans.add(h);
        }
        return ans;
    }
}
