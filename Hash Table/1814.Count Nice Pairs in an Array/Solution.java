class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            int rev = Integer.parseInt(new StringBuilder(String.valueOf(v)).reverse().toString());
            map.put(v - rev, map.getOrDefault(v - rev, 0) + 1);
        }
        long ans = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            ans = (ans + (long) val * (val - 1) / 2 % mod) % mod;
        }
        return (int) ans;
    }
}
