class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[0];
        }
        Map<Integer, Integer> g = new HashMap<>();
        for (int v : changed) {
            g.put(v, g.getOrDefault(v, 0) + 1);
        }
        Arrays.sort(changed);
        int[] ans = new int[n / 2];
        int i = 0;
        for (int v : changed) {
            if (g.getOrDefault(v, 0) == 0) {
                continue;
            }
            if (g.getOrDefault(v * 2, 0) < 1) {
                return new int[0];
            }
            g.put(v, g.get(v) - 1);
            g.put(2 * v, g.get(2 * v) - 1);
            ans[i++] = v;
        }
        return ans;
    }
}