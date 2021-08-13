class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dic = new HashSet<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            while (dic.contains(s.charAt(right))) {
                dic.remove(s.charAt(left));
                left++;
            }
            dic.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}