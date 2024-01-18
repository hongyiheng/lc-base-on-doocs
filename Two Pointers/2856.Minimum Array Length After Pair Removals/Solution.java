class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size(), ans = nums.size();
        int l = n / 2 - 1, r = n - 1;
        while (l >= 0 && r > n / 2 - 1) {
            if (nums.get(r) > nums.get(l)) {
                r--;
                ans -= 2;
            }
            l--;
        }
        return ans;
    }
}