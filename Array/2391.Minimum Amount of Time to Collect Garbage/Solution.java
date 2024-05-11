class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> g = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < garbage.length; i++) {
            String w = garbage[i];
            ans += w.length();
            for (char c : w.toCharArray()) {
                g.put(c, i);
            }
        }
        for (int i = 0; i < travel.length; i++) {
            for (int d : g.values()) {
                if (d > i) {
                    ans += travel[i];
                }
            }
        }
        return ans;
    }
}