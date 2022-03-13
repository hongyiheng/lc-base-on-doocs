class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n <= 2) {
            return n;
        }
        HashMap<Character, Integer> mp = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0, right = 0, win = 2;
        while (right < n) {
            mp.put(chars[right], right);
            if (mp.size() >= 3) {
                int delVal = Integer.MAX_VALUE;
                for (Integer val : mp.values()) {
                    if (val < delVal) {
                        delVal = val;
                    }
                }
                win = Math.max(win, right - left);
                left = delVal + 1;
                mp.remove(s.charAt(delVal));
            }
            right++;
        }
        win = Math.max(win, right - left);
        return win;
    }
}