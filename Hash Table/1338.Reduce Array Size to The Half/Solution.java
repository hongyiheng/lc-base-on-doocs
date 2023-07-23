class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : arr) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        List<Integer> vals = new ArrayList<>(cnt.values());
        vals.sort(Comparator.reverseOrder());
        int ans = 0, cur = 0;
        for (int v : vals) {
            if (cur >= arr.length / 2) {
                break;
            }
            cur += v;
            ans++;
        }
        return ans;
    }
}