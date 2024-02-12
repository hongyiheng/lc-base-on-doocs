class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int l = startIndex, r = startIndex;
        for (int i = 0; i < n; i++) {
            if (target.equals(words[(l + n - i) % n]) || target.equals(words[(r + n + i) % n])) {
                return i;
            }
        }
        return -1;
    }
}