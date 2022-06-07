class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Deque<Integer> stk = new ArrayDeque<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && stk.peekLast() < nums2[i]) {
                mp.put(stk.pollLast(), nums2[i]);
            }
            stk.offerLast(nums2[i]);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = mp.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}