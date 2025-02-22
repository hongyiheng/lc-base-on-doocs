class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> g = new HashMap<>();
        int ans = 0;
        for (String w : words) {
            int v = 0;
            for (char c : w.toCharArray()) {
                v |= (1 << (c - 'a'));
            }
            ans += g.getOrDefault(v, 0);
            g.put(v, g.getOrDefault(v, 0) + 1);
        }
        return ans;
    }
}