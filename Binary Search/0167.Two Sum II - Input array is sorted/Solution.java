class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int t = target - numbers[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (numbers[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (numbers[r] == t) {
                return new int[]{i + 1, r + 1};
            }
        }
        return new int[2];
    }
}