class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int m = groups.length, n = nums.length;
        int i = 0, j = 0;
        while (j < n) {
            if (i >= m) {
                break;
            }
            if (nums[j] == groups[i][0]) {
                int k = 0, y = j;
                while (k < groups[i].length && y < n && nums[y] == groups[i][k]) {
                    y++;
                    k++;
                }
                if (k == groups[i].length) {
                    j = y - 1;
                    i++;
                }
            }
            j++;
        }
        return i == m;
    }
}
