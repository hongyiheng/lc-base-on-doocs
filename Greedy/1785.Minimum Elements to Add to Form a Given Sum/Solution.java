class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long s = 0;
        for (int v : nums) {
            s += v;
        }
        long t = Math.abs(goal - s);
        return (int)((t + limit - 1) / limit);
    }
}
