class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int a = -1, b = -1;
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] != cs2[i]) {
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                } else {
                    return false;
                }
            }
        }
        if (a == -1 || b == -1) {
            return false;
        }
        return cs1[a] == cs2[b] && cs1[b] == cs2[a];
    }
}
