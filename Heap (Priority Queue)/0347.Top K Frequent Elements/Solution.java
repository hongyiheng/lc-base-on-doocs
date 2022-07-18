class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int v : mp.keySet()) {
            if (q.size() < k) {
                q.add(new int[]{v, mp.get(v)});
            } else {
                if (mp.get(v) > q.peek()[1]) {
                    q.poll();
                    q.add(new int[]{v, mp.get(v)});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll()[0];
        }
        return ans;
    }
}