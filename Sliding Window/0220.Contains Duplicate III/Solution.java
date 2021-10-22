class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int m = nums.length;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            if (i > k) {
                ts.remove(nums[i - k - 1]);
            }
            Integer bigOne = ts.ceiling(nums[i]);
            if (bigOne != null && Math.abs((long)bigOne - (long)nums[i]) <= t) {
                return true;
            }
            Integer smallOne = ts.floor(nums[i]);
            if (smallOne != null && Math.abs((long)smallOne - (long)nums[i]) <= t) {
                return true;
            }
            ts.add(nums[i]);
        }
        return false;
    }
}