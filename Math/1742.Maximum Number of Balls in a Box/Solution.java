class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int cur = i, idx = 0;
            while (cur > 0) {
                idx += cur % 10;
                cur /= 10;
            }
            cnt.put(idx, cnt.getOrDefault(idx, 0) + 1);
            ans = Math.max(ans, cnt.get(idx));
        }
        return ans;
    }
}