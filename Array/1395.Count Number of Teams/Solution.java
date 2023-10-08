class Solution {
    public int numTeams(int[] rating) {
        int ans = 0, n = rating.length;
        for (int i = 0; i < n; i++) {
            int llt = 0, rlt = 0, lgt = 0, rgt = 0;
            for (int j = 0; j < n; j++) {
                if (rating[j] < rating[i]) {
                    if (j < i) {
                        llt++;
                    } else {
                        rlt++;
                    }
                }
                if (rating[j] > rating[i]) {
                    if (j < i) {
                        lgt++;
                    } else {
                        rgt++;
                    }
                }
            }
            ans += (llt * rgt) + (lgt * rlt);
        }
        return ans;
    }
}