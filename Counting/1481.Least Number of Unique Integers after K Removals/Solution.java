class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : arr) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        List<Integer> nums = new ArrayList<>();
        for (int v : mp.values()) {
            nums.add(v);
        }
        Collections.sort(nums);
        int ans = nums.size();
        for (int v : nums) {
            if (k < v) {
                break;
            }
            k -= v;
            ans--;
        }
        return ans;
    }
}