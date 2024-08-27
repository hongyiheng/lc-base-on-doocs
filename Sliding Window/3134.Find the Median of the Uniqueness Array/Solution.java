class Solution {

    public boolean check(int[] nums, int x, long k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        long s = 0;
        while (r < nums.length) {
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            while (cnt.keySet().size() > x) {
                int v = cnt.get(nums[l]);
                if (v == 1) {
                    cnt.remove(nums[l]);
                } else {
                    cnt.put(nums[l], --v);
                }
                l++;
            }
            s += r - l + 1;
            if (s >= k) {
                return true;
            }
            r++;
        }
        return false;
    }

    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long k = ((long)(1 + n) * n / 2 + 1) / 2;
        int l = 1, r = (int)1e6;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}