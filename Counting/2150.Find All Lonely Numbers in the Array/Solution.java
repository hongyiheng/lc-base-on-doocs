class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int v : nums) {
            if (cnt.getOrDefault(v, 0) == 1) {
                if (!cnt.containsKey(v - 1) && !cnt.containsKey(v + 1)) {
                    ans.add(v);
                }
            }
        }
        return ans;
    }
}