class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            if (w.length() != pattern.length()) {
                continue;
            }
            Map<Character, Character> a = new HashMap<>();
            Map<Character, Character> b = new HashMap<>();
            boolean same = true;
            for (int i = 0; i < w.length(); i++) {
                if (!a.containsKey(w.charAt(i))) {
                    a.put(w.charAt(i), pattern.charAt(i));
                } else if (a.get(w.charAt(i)) != pattern.charAt(i)){
                    same = false;
                    break;
                }
                if (!b.containsKey(pattern.charAt(i))) {
                    b.put(pattern.charAt(i), w.charAt(i));
                } else if (b.get(pattern.charAt(i)) != w.charAt(i)) {
                    same = false;
                    break;
                }
            }
            if (same) {
                ans.add(w);
            }
        }
        return ans;
    }
}