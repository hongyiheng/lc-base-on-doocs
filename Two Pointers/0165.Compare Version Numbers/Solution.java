class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\."), s2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < s1.length || j < s2.length) {
            int v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int v2 = j < s2.length ? Integer.parseInt(s2[j]) : 0;
            if (v1 == v2) {
                i++;
                j++;
                continue;
            }
            return v1 > v2 ? 1 : -1;
        }
        return 0;
    }
}