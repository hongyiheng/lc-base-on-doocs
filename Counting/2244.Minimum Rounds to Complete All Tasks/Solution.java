class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : tasks) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        for (int k : cnt.keySet()) {
            int cur = cnt.get(k);
            while (cur > 0) {
                ans++;
                if (cur < 2) {
                    return -1;
                }
                if (cur == 4) {
                    cur -= 2;
                } else {
                    cur -= 3;
                }
            }
        }
        return ans;
    }
}