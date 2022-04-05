class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (cnt[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}