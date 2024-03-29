class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0, last = 0;
        for (String row : bank) {
            int cur = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    cur++;
                    ans += last;
                }
            }
            if (cur != 0) {
                last = cur;
            }
        }
        return ans;
    }
}