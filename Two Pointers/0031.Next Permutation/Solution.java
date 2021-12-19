class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int l = -1, r = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (nums[i] < nums[j]) {
                    l = i;
                    r = j;
                }
            }
            if (l != -1) {
                break;
            }
        }
        if (l != -1) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        int i = l == -1 ? 0 : l + 1;
        int j = n - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}