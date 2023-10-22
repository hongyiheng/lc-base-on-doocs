class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        List<Integer> negs = new ArrayList<>();
        int ans = 0, posSum = 0, posCnt = 0;
        for (int v : satisfaction) {
            if (v >= 0) {
                posSum += v;
                ans += v * ++posCnt;
            } else {
                negs.add(v);
            }
        }
        negs.sort((a, b) -> b - a);
        for (int v : negs) {
            int cur = ans + posSum + v;
            if (cur <= ans) {
                break;
            }
            posSum += v;
            ans = cur;
        }
        return ans;
    }
}