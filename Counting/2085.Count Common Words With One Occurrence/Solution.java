class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> g1 = new HashMap<>(), g2 = new HashMap<>();
        for (String w : words1) {
            g1.put(w, g1.getOrDefault(w, 0) + 1);
        }
        for (String w : words2) {
            g2.put(w, g2.getOrDefault(w, 0) + 1);
        }
        int ans = 0;
        for (String w : g1.keySet()) {
            if (g1.get(w) == 1 && g2.getOrDefault(w, 0) == 1) {
                ans++;
            }
        }
        return ans;
    }
}