class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ i >> 1);
        }
        int k = 0;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) == start) {
                k = i;
                break;
            }
        }
        Collections.rotate(ans, -k);
        return ans;
    }
}
