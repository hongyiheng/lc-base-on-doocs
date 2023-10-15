class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int f1 = 0, f2 = 0;
        for (char c : word1.toCharArray()) {
            cnt1[c - 'a']++;
            if (cnt1[c - 'a'] == 1) {
                f1++;
            }
        }
        for (char c : word2.toCharArray()) {
            cnt2[c - 'a']++;
            if (cnt2[c - 'a'] == 1) {
                f2++;
            }
        }
        if (Math.abs(f1 - f2) > 2) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j ++) {
                if (cnt1[i] == 0 || cnt2[j] == 0) {
                    continue;
                }
                if (i == j) {
                    if (f1 == f2) {
                        return true;
                    }
                    continue;
                }
                int v1 = f1, v2 = f2;
                if (cnt1[i] == 1) {
                    v1--;
                }
                if (cnt1[j] == 0) {
                    v1++;
                }
                if (cnt2[j] == 1) {
                    v2--;
                }
                if (cnt2[i] == 0) {
                    v2++;
                }
                if (v1 == v2) {
                    return true;
                }
            }
        }
        return false;
    }
}