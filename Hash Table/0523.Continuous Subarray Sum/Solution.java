class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int last = 0, pre = 0;
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            last = pre;
            pre = (pre + v) % k;
            if (s.contains(pre)) {
                return true;
            }
            s.add(last);
        }
        return false;
    }
}