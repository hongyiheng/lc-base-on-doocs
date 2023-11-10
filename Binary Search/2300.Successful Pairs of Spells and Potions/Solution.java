class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if ((long)spells[i] * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            ans[i] = (long)spells[i] * potions[r] >= success ? m - r : 0;
        }
        return ans;
    }
}