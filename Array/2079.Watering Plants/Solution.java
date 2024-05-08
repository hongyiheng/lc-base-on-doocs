class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0, cur = capacity;
        for (int i = 0; i < plants.length; i++) {
            int v = plants[i];
            if (cur < v) {
                ans += 2 * i;
                cur = capacity;
            }
            cur -= v;
            ans++;
        }
        return ans;
    }
}