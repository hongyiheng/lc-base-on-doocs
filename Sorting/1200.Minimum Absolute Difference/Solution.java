class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length, min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int cur = Math.abs(arr[i] - arr[i - 1]);
            if (min >= cur) {
                if (min > cur) {
                    min = cur;
                    ans.clear();
                }
                List<Integer> item = new ArrayList<>();
                item.add(arr[i - 1]);
                item.add(arr[i]);
                ans.add(item);
            }
        }
        return ans;
    }
}