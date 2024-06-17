class Solution {
    public boolean check(int i, int j, String[] strs) {
        if (i == j || strs[i].length() > strs[j].length()) {
            return false;
        }
        int idx = 0;
        for (char c : strs[j].toCharArray()) {
            if (c == strs[i].charAt(idx)) {
                if (++idx == strs[i].length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() < ans) {
                continue;
            }
            boolean same = false;
            for (int j = 0; j < n; j++) {
                if (check(i, j, strs)) {
                    same = true;
                    break;
                }
            }
            if (!same) {
                ans = strs[i].length();
            }
        }
        return ans;
    }
}