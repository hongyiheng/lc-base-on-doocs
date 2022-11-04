class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int ans = 1, cur = 1;
        while (cur < target) {
            cur += ++ans;
        }
        int diff = cur - target;
        while (diff % 2 != 0) {
            cur += ++ans;
            diff = cur - target;
        }
        return ans;
    }
}
