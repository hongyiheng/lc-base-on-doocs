class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        int n = nums1.length, m = nums2.length;
        for (int i = 0; i < Math.min(n, k); i++) {
            q.offer(new int[]{i, 0});
        }
        while (k-- > 0 && ! q.isEmpty()) {
            int[] cur = q.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums1[cur[0]]);
            tmp.add(nums2[cur[1]]);
            ans.add(tmp);
            if (cur[1] + 1 < m) {
                q.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return ans;
    }
}