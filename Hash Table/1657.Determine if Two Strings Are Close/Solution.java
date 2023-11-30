class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] cnt1 = new int[26];
        for (char c : word1.toCharArray()) {
            cnt1[c - 'a']++;
        }
        int[] cnt2 = new int[26];
        for (char c : word2.toCharArray()) {
            if (cnt1[c - 'a'] == 0) {
                return false;
            }
            cnt2[c - 'a']++;
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return Arrays.equals(cnt1, cnt2);
    }
}