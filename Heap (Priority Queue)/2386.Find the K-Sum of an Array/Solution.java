class Solution {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long s = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                s += nums[i];
            } else {
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);
        PriorityQueue<Pair<Long, Integer>> q = new PriorityQueue<>(Comparator.comparingLong(Pair::getKey));
        q.offer(new Pair<>(0L, 0));
        for (int i = 0; i < k - 1; i++) {
            Pair<Long, Integer> cur = q.poll();
            long sum = cur.getKey();
            int idx = cur.getValue();
            if (idx < n) {
                q.offer(new Pair<>(sum + nums[idx], idx + 1));
                if (idx > 0) {
                    q.offer(new Pair<>(sum + nums[idx] - nums[idx - 1], idx + 1));
                }
            }
        }
        return s - q.poll().getKey();
    }
}