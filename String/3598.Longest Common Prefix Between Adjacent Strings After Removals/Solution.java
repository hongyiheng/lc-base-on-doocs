class Solution {

    public int f(String s1, String s2) {
        int ans = 0;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            ans++;
        }
        return ans;
    }

    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        if (n <= 2) {
            return ans;
        }

        int[] suf = new int[n];
        for (int i = n - 2; i > -1; i--) {
            suf[i] = Math.max(suf[i + 1], f(words[i + 1], words[i]));
        }

        ans[0] = suf[1];
        int pre = 0;
        for (int i = 1; i < n - 1; i++) {
            ans[i] = Math.max(pre, Math.max(f(words[i - 1], words[i + 1]), suf[i + 1]));
            pre = Math.max(pre, f(words[i - 1], words[i]));
        }
        ans[n - 1] = pre;
        return ans;
    }
}