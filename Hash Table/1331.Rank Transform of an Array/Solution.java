class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = arr.clone();
        Arrays.sort(arr);
        Map<Integer, Integer> mp = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(arr[i])) {
                mp.put(arr[i], idx++);
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = mp.get(ans[i]);
        }
        return ans;
    }
}