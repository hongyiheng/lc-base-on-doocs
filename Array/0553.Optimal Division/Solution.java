class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder ans = new StringBuilder();
        if (n == 1) {
            ans.append(nums[0]);
        } else if (n == 2) {
            ans.append(nums[0] + "/" + nums[1]);
        } else {
            ans.append(nums[0] + "/(" + nums[1]);
            for (int i = 2; i < n; i++) {
                ans.append("/" + nums[i]);
            }
            ans.append(")");
        }
        return ans.toString();
    }
}