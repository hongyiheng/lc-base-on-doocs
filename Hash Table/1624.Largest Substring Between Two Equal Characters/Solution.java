class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> mp = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < cs.length; i++) {
            if (mp.containsKey(cs[i])) {
                ans = Math.max(ans, i - mp.get(cs[i]) - 1);
            } else {
                mp.put(cs[i], i);
            }
        }
        return ans;
    }
}