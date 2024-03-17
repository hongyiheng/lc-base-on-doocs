class Solution {
    public int maximumLength(int[] nums) {
        Integer INF = Integer.MAX_VALUE;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        Arrays.sort(nums);
        int ans = 1;
        Set<Integer> vis = new HashSet<>();
        for (int v : nums) {
            if (cnt.getOrDefault(v, 0) < 2 || v == 1 || vis.contains(v)) {
                continue;
            }
            int x = v, d = 1;
            while ((long)x * x < INF && cnt.getOrDefault(x * x, 0) >= 2) {
                vis.add(x);
                d++;
                x *= x;
            }
            d = d * 2 + ((long)x * x < INF && cnt.containsKey(x * x) ? 1 : -1);
            ans = Math.max(ans, d);
        }
        if (cnt.containsKey(1)) {
            int v = cnt.get(1);
            ans = Math.max(ans, v / 2 * 2 + (v % 2 == 1 ? 1 : -1));
        }
        return ans;
    }
}