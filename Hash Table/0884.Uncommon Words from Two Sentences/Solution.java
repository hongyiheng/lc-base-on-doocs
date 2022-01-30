class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> mp = new HashMap<>();
        for (String w : A.split(" ")) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        for (String w : B.split(" ")) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String k : mp.keySet()) {
            if (mp.get(k) == 1) {
                ans.add(k);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}