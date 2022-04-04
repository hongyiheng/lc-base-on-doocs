class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums1) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        List<Integer> tmp = new ArrayList<>();
        for (int num : nums2) {
            int cnt = mp.getOrDefault(num, 0);
            if (cnt > 0) {
                tmp.add(num);
                mp.put(num, --cnt);
            }
        }
        int[] ans = new int[tmp.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}