class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            int l = i, r = i;
            while (r + 1 < n && nums[r] + 1 == nums[r + 1]) {
                r++;
            }
            if (l == r) {
                ans.add(String.valueOf(nums[l]));
            } else {
                ans.add(nums[l] + "->" + nums[r]);
            }
            i = r + 1;
        }
        return ans;

    }
}