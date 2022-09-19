class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[5010];
        for (int v : nums) {
            cnt[v]++;
        }
        int j = 5000;
        for (int i = 1; i < n; i += 2) {
            while (cnt[j] == 0) {
                j--;
            }
            nums[i] = j;
            cnt[j]--;
        }
        for (int i = 0; i < n; i += 2) {
            while (cnt[j] == 0) {
                j--;
            }
            nums[i] = j;
            cnt[j]--;
        }
    }
}