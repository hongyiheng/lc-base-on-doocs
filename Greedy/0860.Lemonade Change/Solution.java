class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int num : bills) {
            if (num == 5) {
                fiveCount++;
            } else if (num == 10) {
                tenCount++;
                fiveCount--;
            } else if (num == 20) {
                if (tenCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else {
                    fiveCount -= 3;
                }
            }
            if (fiveCount < 0) {
                return false;
            }
        }
        return true;
    }
}