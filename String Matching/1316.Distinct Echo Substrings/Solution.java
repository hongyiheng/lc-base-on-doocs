class Solution {

    public int[] getNxt(String s) {
        int n = s.length();
        int[] nxt = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                nxt[i++] = ++j;
            } else if (j != 0) {
                j = nxt[j - 1];
            } else {
                i++;
            }
        }
        return nxt;
    }

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int[] nxt = getNxt(text.substring(i));
            for (int j = 0; j < nxt.length; j++) {
                if (nxt[j] == 0 || (j + 1) % 2 != 0) {
                    continue;
                }
                if ((j + 1) % (j + 1 - nxt[j]) == 0 && (j + 1) / (j + 1 - nxt[j]) % 2 == 0) {
                    ans.add(text.substring(i, i + j + 1));
                }
            }
        }
        return ans.size();
    }
}