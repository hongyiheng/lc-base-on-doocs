class Solution {
    public int maximizeSum(int[] nums, int k) {
        int mv = 0;
        for (int v : nums) {
            mv = Math.max(mv, v);
        }
        return (mv + mv + k - 1) * k / 2;
    }
}