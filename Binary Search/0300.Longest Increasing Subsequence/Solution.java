class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int left = 0;
            int right = res;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (tail[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tail[left] = num;
            if (left == res) {
                res++;
            }
        }
        return res;
    }
}