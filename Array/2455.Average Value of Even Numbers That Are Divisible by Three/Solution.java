class Solution {
    public int averageValue(int[] nums) {
        int s = 0, c = 0;
        for (int v : nums) {
            if (v % 6 == 0) {
                s += v;
                c++;
            }
        }
        return c == 0 ? 0 : s / c;
    }
}
