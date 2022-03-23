class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int nodeCount = getNodeCount(n, cur);
            if (k >= nodeCount) {
                k -= nodeCount;
                cur ++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    public int getNodeCount(int n, long cur) {
        int nodeCount = 0;
        long next = cur + 1;
        while (cur <= n) {
            nodeCount += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return nodeCount;
    }
}