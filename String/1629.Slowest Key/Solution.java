class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int curTime = releaseTimes[i] - releaseTimes[i - 1];
            if (maxTime < curTime) {
                ans = keysPressed.charAt(i);
                maxTime = curTime;
            } else if (maxTime == curTime && ans < keysPressed.charAt(i)) {
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }
}