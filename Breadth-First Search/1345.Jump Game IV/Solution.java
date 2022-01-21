class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        steps[0] = 0;
        while (!q.isEmpty()) {
            int cur = q.pollFirst(), step = steps[cur];
            if (cur == n - 1) {
                return step;
            }
            if (cur - 1 >= 0 && steps[cur - 1] == Integer.MAX_VALUE) {
                q.addLast(cur - 1);
                steps[cur - 1] = step + 1;
            }
            if (cur + 1 < n && steps[cur + 1] == Integer.MAX_VALUE) {
                q.addLast(cur + 1);
                steps[cur + 1] = step + 1;
            }
            List<Integer> same = mp.getOrDefault(arr[cur], Collections.emptyList());
            for (int index : same) {
                if (steps[index] == Integer.MAX_VALUE) {
                    q.addLast(index);
                    steps[index] = step + 1;
                }
            }
            mp.remove(arr[cur]);
        }
        return -1;
    }
}