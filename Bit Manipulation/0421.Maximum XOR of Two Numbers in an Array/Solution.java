class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0, mask = 0;
        for (int i = 30; i > -1; i--) {
            mask |= 1 << i;
            int newAns = ans | 1 << i;
            Set<Integer> vis = new HashSet<>();
            for (int v : nums) {
                v &= mask;
                if (vis.contains(newAns ^ v)) {
                    ans = newAns;
                    break;
                }
                vis.add(v);
            }
        }
        return ans;
    }
}