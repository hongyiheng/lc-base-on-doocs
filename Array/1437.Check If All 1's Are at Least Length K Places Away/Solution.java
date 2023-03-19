class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int cnt = k;
        for (int v : nums) {
            if (v == 1) {
                if (cnt >= k) {
                    cnt = 0;
                } else {
                    return false;
                }
            } else {
                cnt++;
            }
        }
        return true;
    }
}