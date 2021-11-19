class Solution {
    public int[] shuffle(int[] nums, int n) {
        int left = 0, right = n;
        int[] res = new int[2*n];
        for(int i = 0; i < 2*n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[left++];
            } else {
                res[i] = nums[right++];
            }
        }
        return res;
    }
}