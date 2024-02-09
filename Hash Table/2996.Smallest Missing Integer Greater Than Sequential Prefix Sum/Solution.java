class Solution {
    public int missingInteger(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }
            x += nums[i];
        }
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        while (s.contains(x)) {
            x++;
        }
        return x;
    }
}