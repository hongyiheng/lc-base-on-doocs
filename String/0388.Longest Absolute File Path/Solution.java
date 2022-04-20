class Solution {
    public int lengthLongestPath(String input) {
        char[] chars = input.toCharArray();
        int ans = 0;
        int i = 0, n = input.length();
        Map<Integer, Integer> mp = new HashMap<>();
        while (i < n) {
            int level = 0;
            while (i < n && chars[i] == '\t') {
                i++;
                level++;
            }
            int j = i;
            boolean isDir = true;
            while (j < n && chars[j] != '\n') {
                if (chars[j++] == '.') {
                    isDir = false;
                }
            }
            int cur = level == 0 ? j - i : j - i + 1;
            int curLen = mp.getOrDefault(level - 1, 0) + cur;
            if (isDir) {
                mp.put(level, curLen);
            } else {
                ans = Math.max(ans, curLen);
            }
            i = j + 1;
        }
        return ans;
    }
}