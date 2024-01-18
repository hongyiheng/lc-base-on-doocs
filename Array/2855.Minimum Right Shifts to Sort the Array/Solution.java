class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int i = 1, n = nums.size();
        while (i < n) {
            if (nums.get(i) < nums.get(i - 1)) {
                break;
            }
            i++;
        }
        for (int j = 1; j < n; j++) {
            if (nums.get((i + j) % n) < nums.get((i + j - 1) % n)) {
                return -1;
            }
        }
        return n - i;
    }
}