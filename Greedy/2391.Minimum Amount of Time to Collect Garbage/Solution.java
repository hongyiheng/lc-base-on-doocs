class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int g = 0, m = 0, p = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                if (c == 'G') {
                    g = i;
                } else if (c == 'M') {
                    m = i;
                } else {
                    p = i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < garbage.length; i++) {
            ans += garbage[i].length();
            if (i < g) {
                ans += travel[i];
            }
            if (i < m) {
                ans += travel[i];
            }
            if (i < p) {
                ans += travel[i];
            }
        }
        return ans;
    }
}
