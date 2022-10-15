class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int idx = 0, m = target.length;
        for (int i = 1; i < n + 1; i++) {
            if (idx == m) {
                break;
            }
            if (target[idx] != i) {
                ans.add("Push");
                ans.add("Pop");
            } else {
                idx++;
                ans.add("Push");
            }
        }
        return ans;
    }
}
