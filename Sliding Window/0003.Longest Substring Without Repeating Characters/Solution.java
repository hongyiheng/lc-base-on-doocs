class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int left = 0, n = s.length(), ans = 0;
        for (int right = 0; right < n; right++) {
            while (cnt.getOrDefault(s.charAt(right), 0) == 1) {
                cnt.put(s.charAt(left++), 0);
            }
            cnt.put(s.charAt(right), 1);
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }
}