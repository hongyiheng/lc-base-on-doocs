class Solution {
    int n;
    public boolean circularArrayLoop(int[] nums) {
        n = nums.length;
        for (int i = 0; i < n; i++) {
            if (check(i, nums)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int i, int[] nums) {
        int slow = i;
        int fast = next(slow, nums);
        while (nums[fast] * nums[i] > 0 && nums[next(fast, nums)] * nums[i] > 0) {
            if (slow == fast) {
                if (slow == next(slow, nums)) {
                    break;
                }
                return true;
            }
            slow = next(slow, nums);
            fast = next(next(fast, nums), nums);
        }
        return false;
    }

    private int next(int index, int[] nums) {
        int res = index + nums[index];
        while (res < 0) {
            res += n;
        }
        return res % n;
    }
}