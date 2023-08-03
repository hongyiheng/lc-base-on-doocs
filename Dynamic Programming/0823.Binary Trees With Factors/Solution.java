class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Long> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            mp.put(a, 1L);
            for (int j = i; j > -1; j--) {
                int b = arr[j];
                if (a % b != 0 || a / b > b || !mp.containsKey(a / b)) {
                    continue;
                }
                long v = a / b == b ? mp.get(b) * mp.get(b) : mp.get(b) * mp.get(a / b) * 2;
                mp.put(a, mp.get(a) + v);
            }
        }
        int mod = (int)1e9 + 7;
        long ans = 0L;
        for (long v : mp.values()) {
            ans += v;
            ans %= mod;
        }
        return (int)ans;
    }
}