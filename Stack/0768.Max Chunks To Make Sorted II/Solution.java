class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] nums = arr.clone();
        Arrays.sort(nums);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0, idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!q.isEmpty()) {
                while (!q.isEmpty() && q.peek() == nums[idx]) {
                    q.poll();
                    idx++;
                }
                if (q.isEmpty()) {
                    ans++;
                }
            }
            q.add(arr[i]);
        }
        return q.isEmpty() ? ans : ans + 1;
    }
}