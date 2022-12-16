class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        int n = nums.length;
        int[] in = new int[n + 1];
        for (List<Integer> seq : sequences) {
            for (int i = 1; i < seq.size(); i++) {
                mp.computeIfAbsent(seq.get(i - 1), k -> new HashSet<>()).add(seq.get(i));
                in[seq.get(i)]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        int idx = 0;
        while (!q.isEmpty()) {
            if (q.size() != 1) {
                return false;
            }
            int cur = q.poll();
            if (cur != nums[idx++]) {
                return false;
            }
            for (int nxt : mp.getOrDefault(cur, new HashSet<>())) {
                in[nxt]--;
                if (in[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
        return true;
    }
}
