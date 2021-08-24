class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stk = new ArrayDeque<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stk.isEmpty() && nums2[stk.peekLast()] < nums2[i]) {
                mp.put(nums2[stk.pollLast()], nums2[i]);
            }
            stk.addLast(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = mp.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}