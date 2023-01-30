class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0, i = 0;
        while (i * cost1 <= total) {
            ans += (total - i * cost1) / cost2 + 1;
            i++;
        }
        return ans;
    }
}
