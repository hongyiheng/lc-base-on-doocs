class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String w : strs) {
            char[] cs = w.toCharArray();
            Arrays.sort(cs);
            mp.computeIfAbsent(new String(cs), k -> new ArrayList<>()).add(w);
        }
        return new ArrayList<>(mp.values());
    }
}