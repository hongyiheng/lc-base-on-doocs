class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int m = s1.length(), n = s2.length();
        int i = 0, j = 0;
        Map<Integer, int[]> ids = new HashMap<>();
        while (i < m * n1) {
            if (s1.charAt(i % m) == s2.charAt(j % n)) {
                i++;
                j++;
                if (j % n == 0) {
                    if (ids.containsKey(i % m)) {
                        int[] last = ids.get(i % m);
                        int iDist = i - last[0], jDist = j - last[1];
                        int v = (m * n1 - i) / iDist;
                        i += v * iDist;
                        j += v * jDist;
                    } else {
                        ids.put((i % m), new int[]{i, j});
                    }
                }
            } else {
                i++;
            }
        }
        return j / n / n2;
    }
}