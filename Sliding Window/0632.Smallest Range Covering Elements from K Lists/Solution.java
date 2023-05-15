class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int v : nums.get(i)) {
                q.add(new int[]{v, i});
            }
        }
        Collections.sort(q, Comparator.comparingInt(o -> o[0]));
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0, ansL = q.get(0)[0], ansR = q.get(q.size() - 1)[0];
        while (r < q.size()) {
            int[] cur = q.get(r);
            cnt.put(cur[1], cnt.getOrDefault(cur[1], 0) + 1);
            while (cnt.size() == n) {
                if (q.get(r)[0] - q.get(l)[0] < ansR - ansL) {
                    ansL = q.get(l)[0];
                    ansR = q.get(r)[0];
                }
                int[] curL = q.get(l++);
                cnt.put(curL[1], cnt.get(curL[1]) - 1);
                if (cnt.get(curL[1]) == 0) {
                    cnt.remove(curL[1]);
                }
            }
            r++;
        }
        return new int[]{ansL, ansR};
    }
}
