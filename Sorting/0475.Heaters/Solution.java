class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int heaterIndex = 0;
        for (int house : houses) {
            while (heaterIndex <= heaters.length - 2 && Math.abs(heaters[heaterIndex + 1] - house) <= Math.abs(heaters[heaterIndex] - house)) {
                ++heaterIndex;
            }
            if (Math.abs(heaters[heaterIndex] - house) > ans) {
                ans = Math.abs(heaters[heaterIndex] - house);
            }
        }
        return ans;
    }
}