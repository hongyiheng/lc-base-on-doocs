class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> mp = new HashMap<>();
        for (int[] v : pieces) {
            mp.put(v[0], v);
        }
        int n = arr.length, idx = 0;
        while (idx < n) {
            if (!mp.containsKey(arr[idx])) {
                return false;
            }
            int[] nums = mp.remove(arr[idx]);
            for (int v : nums) {
                if (v == arr[idx]) {
                    idx++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
