class WordDistance {
    Map<Integer, List<Integer>> mp;

    public WordDistance(String[] wordsDict) {
        mp = new HashMap();
        for (int i = 0; i < wordsDict.length; i++) {
            mp.computeIfAbsent(wordsDict[i].hashCode(), k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        List<Integer> index1 = mp.get(word1.hashCode());
        List<Integer> index2 = mp.get(word2.hashCode());
        for (int i : index1) {
            for (int j : index2) {
                ans = Math.min(Math.abs(i - j), ans);
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */