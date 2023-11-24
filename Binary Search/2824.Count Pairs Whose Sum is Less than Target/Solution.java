class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size(), ans = 0;
        nums.sort((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (nums.get(i) + nums.get(mid) < target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (nums.get(i) + nums.get(r) < target) {
                ans += r - i;
            }
        }
        return ans;
    }
}