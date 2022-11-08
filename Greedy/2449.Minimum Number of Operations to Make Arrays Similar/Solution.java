class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                nums[i] = -nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (target[i] % 2 != 0) {
                target[i] = -target[i];
            }
        }
        Arrays.sort(nums);
        Arrays.sort(target);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(nums[i] - target[i]);
        }
        return sum / 4;
    }
}
