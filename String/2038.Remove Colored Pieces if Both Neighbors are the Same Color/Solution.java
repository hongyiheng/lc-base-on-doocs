class Solution {
    public boolean winnerOfGame(String colors) {
        int aTime = 0, bTime = 0;
        char[] chars = colors.toCharArray();
        int curLen = 0;
        char cur = '.';
        for (char c : chars) {
            if (cur != c) {
                cur = c;
                curLen = 1;
            } else {
                curLen++;
                if (curLen >= 3) {
                    if (cur == 'A') {
                        aTime++;
                    } else {
                        bTime++;
                    }
                }
            }
        }
        return aTime > bTime;
    }
}