class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        List<int[]> q = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            q.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(q, (a, b) -> b[1] - a[1]);
        if (q.size() >= 2 && q.get(0)[1] == q.get(1)[1]) {
            return -1;
        }
        int n = nums.size();
        int x = q.get(0)[0], s = q.get(0)[1];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int v = nums.get(i);
            if (v == x) {
                cur++;
            }
            if (cur * 2 > i + 1 && (s - cur) * 2 > n - i - 1) {
                return i;
            }
        }
        return -1;
    }
}