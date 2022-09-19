class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
            arr.add(v);
        }
        Collections.sort(arr, (a, b) -> {
            if (mp.get(a) != mp.get(b)) {
                return mp.get(a) - mp.get(b);
            }
            return b - a;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr.get(i);
        }
        return nums;
    }
}