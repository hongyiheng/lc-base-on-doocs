class Solution {
    public int averageValue(int[] nums) {
        int val = 0, cnt = 0;
        for (int v : nums) {
            if (v % 2 == 0 && v % 3 == 0) {
                val += v;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : val / cnt;
    }
}
