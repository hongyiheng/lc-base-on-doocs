class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Map<Integer, Double> ts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ts.put(position[i], (double)(target - position[i]) / speed[i]);
        }
        Arrays.sort(position);
        int ans = 0;
        double slow = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (ts.get(position[i]) > slow) {
                ans++;
                slow = ts.get(position[i]);
            }
        }
        return ans;
    }
}