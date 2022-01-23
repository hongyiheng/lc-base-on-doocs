class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = mp.getOrDefault(arr[i] + difference, 0) + 1;
            mp.put(arr[i], cur);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}