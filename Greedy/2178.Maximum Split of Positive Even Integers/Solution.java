class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return ans;
        }
        long cur = 2;
        while (cur * 2 < finalSum) {
            ans.add(cur);
            finalSum -= cur;
            cur += 2;
        }
        if (finalSum > 0) {
            ans.add(finalSum);
        }
        return ans;
    }
}