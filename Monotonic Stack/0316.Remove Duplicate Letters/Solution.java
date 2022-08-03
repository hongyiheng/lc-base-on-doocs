class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        Set<Character> used = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!used.contains(c)) {
                while (ans.length() > 0 && ans.charAt(ans.length() - 1) > c && cnt[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                    used.remove(ans.charAt(ans.length() - 1));
                    ans.deleteCharAt(ans.length() - 1);
                }
                used.add(c);
                ans.append(c);
            }
            cnt[c - 'a']--;
        }
        return ans.toString();
    }
}