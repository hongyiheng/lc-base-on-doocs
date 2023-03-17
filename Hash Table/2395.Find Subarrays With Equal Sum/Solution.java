class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> vis = new HashSet<>();
        int i = 0;
        while (i < n - 1) {
            int s = nums[i] + nums[i + 1];
            if (vis.contains(s)) {
                return true;
            }
            vis.add(s);
            i++;
        }
        return false;
    }
}
