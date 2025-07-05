class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : arr) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int ans = -1;
        for (int k : cnt.keySet()) {
            if (cnt.get(k) == k) {
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
}