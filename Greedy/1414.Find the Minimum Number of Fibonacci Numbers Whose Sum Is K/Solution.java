class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> nums = new ArrayList<>();
        int a = 1, b = 1;
        nums.add(1);
        while (b <= k) {
            int c = a + b;
            nums.add(c);
            a = b;
            b = c;
        }
        int ans = 0;
        while (k > 0) {
            k -= findSmaller(nums, k);
            ans++;
        }
        return ans;
    }

    public int findSmaller(List<Integer> nums, int k) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums.get(mid) <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums.get(left);
    }
}