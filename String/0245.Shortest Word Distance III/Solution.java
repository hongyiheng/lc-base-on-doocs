class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        Map<String, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            if (!w.equals(word1) && !w.equals(word2)) {
                continue;
            }
            if (w.equals(word1)) {
                if (mp.containsKey(word2)) {
                    ans = Math.min(ans, i - mp.get(word2));
                }
            } else {
                if (mp.containsKey(word1)) {
                    ans = Math.min(ans, i - mp.get(word1));
                }
            }
            mp.put(w, i);
        }
        return ans;
    }
}
