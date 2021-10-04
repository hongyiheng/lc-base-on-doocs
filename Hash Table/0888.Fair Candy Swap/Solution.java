class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = Arrays.stream(aliceSizes).sum();
        int sum2 = Arrays.stream(bobSizes).sum();
        int diff = (sum1 - sum2) / 2;
        Set<Integer> dict = new HashSet<>();
        for (int num : bobSizes) {
            dict.add(num);
        }
        int[] ans = null;
        for (int x : aliceSizes) {
            int y = x - diff;
            if (dict.contains(y)) {
                ans = new int[]{x, y};
                return ans;
            }
        }
        return ans;
    }
}