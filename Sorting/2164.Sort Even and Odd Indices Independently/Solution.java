class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        List<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
        odd.sort((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even.get(i / 2);
            } else {
                nums[i] = odd.get((i - 1) / 2);
            }
        }
        return nums;
    }
}