class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        Map<String, Integer> cnt = new HashMap<>();
        for (List<Integer> v : coordinates) {
            int x = v.get(0), y = v.get(1);
            String key = x + ":" + y;
            for (int i = 0; i <= k; i++) {
                int nx = i ^ x, ny = (k - i) ^ y;
                ans += cnt.getOrDefault(nx + ":" + ny, 0);
            }
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }
        return ans;
    }
}