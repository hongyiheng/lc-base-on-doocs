class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        char[] chars = paragraph.toCharArray();
        Set<String> ban = new HashSet<>();
        for (String w : banned) {
            ban.add(w);
        }
        Map<String, Integer> cnt = new HashMap<>();
        String cur = "";
        String ans = "";
        for (char c : chars) {
            if (Character.isLetter(c)) {
                cur += c;
                continue;
            }
            String word = cur;
            cur = "";
            if (word == "" || ban.contains(word)) {
                continue;
            }
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            if (cnt.getOrDefault(ans, 0) < cnt.get(word)) {
                ans = word;
            }
        }
        if (cur != "" && cnt.getOrDefault(ans, 0) < cnt.getOrDefault(cur, 0) + 1) {
            ans = cur;
        }
        return ans;
    }
}