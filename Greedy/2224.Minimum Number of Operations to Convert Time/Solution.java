class Solution {
    public int convertTime(String current, String correct) {
        int cur = Integer.parseInt(current.split(":")[0]) * 60 + Integer.parseInt(current.split(":")[1]);
        int target = Integer.parseInt(correct.split(":")[0]) * 60 + Integer.parseInt(correct.split(":")[1]);
        int ans = 0;
        while (cur < target) {
            int diff = target - cur;
            if (diff >= 60) {
                cur += 60;
            } else if (diff >= 15) {
                cur += 15;
            } else if (diff >= 5) {
                cur += 5;
            } else {
                cur++;
            }
            ans++;
        }
        return ans;
    }
}