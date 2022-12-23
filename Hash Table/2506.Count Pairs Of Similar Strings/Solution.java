class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (String w : words) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            ans += mp.getOrDefault(mask, 0);
            mp.put(mask, mp.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }
}