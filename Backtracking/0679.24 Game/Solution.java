class Solution {
    boolean ans = false;
    double diff = 1e-6;

    public boolean judgePoint24(int[] cards) {
        int n = cards.length;
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cards[i];
        }
        dfs(nums);
        return ans;
    }

    public void dfs(double[] nums) {
        if (ans) {
            return;
        }
        int n = nums.length;
        if (n == 1) {
            if (Math.abs(nums[0] - 24) < diff) {
                ans = true;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                double[] newNums = new double[n - 1];
                newNums[0] = nums[i] + nums[j];
                fillArray(nums, newNums, i, j);
                dfs(newNums);
                newNums[0] = nums[i] - nums[j];
                fillArray(nums, newNums, i, j);
                dfs(newNums);
                newNums[0] = nums[i] * nums[j];
                fillArray(nums, newNums, i, j);
                dfs(newNums);
                if (nums[j] != 0) {
                    newNums[0] = nums[i] / nums[j];
                    fillArray(nums, newNums, i, j);
                    dfs(newNums);
                }
            }
        }
    }

    public void fillArray(double[] nums, double[] newNums, int i, int j) {
        int idx = 0;
        for (int k = 1; k < newNums.length; k++) {
            while (idx == i || idx == j) {
                idx++;
            }
            newNums[k] = nums[idx++];
        }
    }
}