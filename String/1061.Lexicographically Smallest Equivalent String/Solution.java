class Solution {

    int[] p = new int[26];

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);

        }
        return p[x];
    }

    public void union(int a, int b) {
        int r1 = find(a), r2 = find(b);
        if (r1 < r2) {
            p[r2] = r1;
        } else {
            p[r1] = r2;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            p[i] = i;
        }
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
            union(a, b);
        }
        char[] cs = baseStr.toCharArray();
        for (int i = 0; i < baseStr.length(); i++) {
            cs[i] = (char)(find(cs[i] - 'a') + 'a');
        }
        return new String(cs);
    }
}