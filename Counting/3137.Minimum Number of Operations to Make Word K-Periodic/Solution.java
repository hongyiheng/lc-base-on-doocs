class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        int n = word.length();
        for (int i = 0; i < n; i += k) {
            String s = word.substring(i, i + k);
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        int mx = 0;
        for (int v : cnt.values()) {
            mx = Math.max(mx, v);
        }
        return n / k - mx;
    }
}